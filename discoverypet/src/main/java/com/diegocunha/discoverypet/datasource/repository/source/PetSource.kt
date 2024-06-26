package com.diegocunha.discoverypet.datasource.repository.source

import com.diegocunha.datasource.model.response.Pet
import com.diegocunha.datasource.model.response.PetResponse
import com.diegocunha.datasource.network.network.DiscoveryPetService
import com.diegocunha.datasource.templates.BasePaginationSource

class PetSource(
    private val api: DiscoveryPetService,
) : BasePaginationSource<Pet>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pet> {
        return try {
            val nextPage = params.key ?: DEFAULT_PAGE
            val response = api.getPets(nextPage, DEFAULT_PAGE_SIZE)

            LoadResult.Page(
                data = response.data,
                prevKey = response.prevPage(),
                nextKey = response.nextPage()
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    private fun PetResponse.prevPage(): Int? =
        if (meta.pagination.page - DEFAULT_PAGE_INCREMENT < DEFAULT_PAGE) {
            null
        } else {
            meta.pagination.page.toInt() - DEFAULT_PAGE_INCREMENT
        }


    private fun PetResponse.nextPage(): Int? =
        if (meta.pagination.page + DEFAULT_PAGE_INCREMENT < meta.pagination.pageCount) {
            meta.pagination.page.toInt() + DEFAULT_PAGE_INCREMENT
        } else {
            null
        }

    companion object {
        private const val DEFAULT_PAGE = 1
        private const val DEFAULT_PAGE_SIZE = 10
        private const val DEFAULT_PAGE_INCREMENT = 1
    }
}