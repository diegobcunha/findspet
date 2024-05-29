package com.diegocunha.petdetail.ui.detail

import com.diegocunha.commons.coroutines.DispatchersProvider
import com.diegocunha.commons.templates.SuspendFetchViewModel
import com.diegocunha.commons.templates.state.GetState
import com.diegocunha.commons.templates.state.toGetState
import com.diegocunha.petdetail.datasource.repository.PetDetailRepository

class PetDetailViewModel(
    dispatchersProvider: DispatchersProvider,
    private val repository: PetDetailRepository,
    private val id: Long
) :
    SuspendFetchViewModel<PetDetailUi>(dispatchersProvider) {
    override suspend fun fetch(): GetState<PetDetailUi> {
        return repository.getPetDetail(id).map {
            PetDetailUi(
                it.data.attributes.name
            )
        }.toGetState()
    }
}

data class PetDetailUi(
    val name: String?
)