package com.diegocunha.petdetail.ui.detail

import com.diegocunha.commons.coroutines.DispatchersProvider
import com.diegocunha.commons.templates.SuspendFetchViewModel
import com.diegocunha.commons.templates.state.GetState

class PetDetailViewModel(
    dispatchersProvider: DispatchersProvider,
    private val id: Long
) :
    SuspendFetchViewModel<PetDetailUi>(dispatchersProvider) {
    override suspend fun fetch(): GetState<PetDetailUi> {
        return GetState.success(PetDetailUi("Perrito"))
    }
}

data class PetDetailUi(
    val name: String?
)