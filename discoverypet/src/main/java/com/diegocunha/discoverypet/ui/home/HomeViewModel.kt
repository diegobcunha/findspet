package com.diegocunha.discoverypet.ui.home

import androidx.paging.PagingData
import com.diegocunha.commons.coroutines.DispatchersProvider
import com.diegocunha.commons.templates.PaginationViewModel
import com.diegocunha.datasource.extensions.transformPagingData
import com.diegocunha.discoverypet.domain.usecase.FindPetUseCase
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    dispatchersProvider: DispatchersProvider,
    private val useCase: FindPetUseCase
) :
    PaginationViewModel<PetUi>(dispatchersProvider, DEFAULT_PAGE_SIZE) {

    override fun fetchContent(initialPageSize: Int): Flow<PagingData<PetUi>> {
        return useCase(initialPageSize).transformPagingData {
            PetUi(
                it.image,
                it.type,
                it.city
            )
        }
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 12
    }
}