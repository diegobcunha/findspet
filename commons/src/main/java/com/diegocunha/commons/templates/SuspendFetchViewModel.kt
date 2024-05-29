package com.diegocunha.commons.templates

import com.diegocunha.commons.coroutines.DispatchersProvider
import com.diegocunha.commons.templates.state.GetState
import com.diegocunha.commons.templates.state.retryState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class SuspendFetchViewModel<T>(dispatchersProvider: DispatchersProvider) :
    BaseViewModel(dispatchersProvider) {

    private val _stateFlow: MutableStateFlow<GetState<T>> by lazy {
        MutableStateFlow<GetState<T>>(GetState.initial()).apply {
            launchIO {
                emit(fetch())
            }
        }
    }

    val stateFlow: StateFlow<GetState<T>> by lazy { _stateFlow.asStateFlow() }

    /**
     * Function which will be implemented by other classes to make network calls
     */
    abstract suspend fun fetch(): GetState<T>

    /**
     * Retry method in cases where the network call fails
     */
    fun retry() {
        launchIO {
            _stateFlow.retryState(::fetch)
        }
    }
}