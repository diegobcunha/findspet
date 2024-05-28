package com.diegocunha.discoverypet.ui.home

import androidx.paging.PagingData
import com.diegocunha.commons.coroutines.DispatchersProvider
import com.diegocunha.commons.templates.PaginationViewModel
import com.diegocunha.datasource.extensions.transformPagingData
import com.diegocunha.discoverypet.domain.model.PetStatusDomain
import com.diegocunha.discoverypet.domain.model.PetTypeDomain
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
                it.name,
                it.image,
                it.type.toUi(),
                it.statusDomain.toUi(),
                it.city
            )
        }
    }

    private fun PetTypeDomain.toUi() = when (this) {
        PetTypeDomain.DOG -> PetUiType.DOG
        PetTypeDomain.CAT -> PetUiType.CAT
    }

    private fun PetStatusDomain.toUi() = when (this) {
        PetStatusDomain.MISSED -> PetUiStatus.MISSED
        PetStatusDomain.SEARCH_OWNER -> PetUiStatus.SEARCH
    }

    companion object {
        private const val DEFAULT_PAGE_SIZE = 12
    }
}