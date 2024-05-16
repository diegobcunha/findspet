package com.diegocunha.discoverypet.ui.home

import androidx.paging.PagingData
import com.diegocunha.commons.coroutines.DispatchersProvider
import com.diegocunha.commons.templates.PaginationViewModel
import com.diegocunha.discoverypet.domain.model.PetDomain
import com.diegocunha.discoverypet.domain.usecase.FindPetUseCase
import kotlinx.coroutines.flow.Flow

class HomeViewModel(dispatchersProvider: DispatchersProvider,
    private val useCase: FindPetUseCase) :
    PaginationViewModel<PetDomain>(dispatchersProvider, 12) {

    override fun fetchContent(initialPageSize: Int): Flow<PagingData<PetDomain>> {
        return useCase.invoke(initialPageSize)
    }
}