package com.diegocunha.discoverypet.datasource.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.diegocunha.discoverypet.datasource.network.DiscoveryPetService
import com.diegocunha.discoverypet.datasource.repository.source.PetSource

class PetRepositoryImpl(
    private val api: DiscoveryPetService,
) : PetRepository {

    override fun searchPets(initialSize: Int) = Pager(
        PagingConfig(
            pageSize = initialSize,
            prefetchDistance = 2,
            initialLoadSize = initialSize
        )
    ) { PetSource(api) }.flow
}