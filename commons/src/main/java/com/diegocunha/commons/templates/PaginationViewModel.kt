package com.diegocunha.commons.templates

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.diegocunha.commons.coroutines.DispatchersProvider
import kotlinx.coroutines.flow.Flow

abstract class PaginationViewModel<T : Any>(
    dispatchersProvider: DispatchersProvider,
    initialLoadSize: Int
) :
    BaseViewModel(dispatchersProvider) {

    /**
     * Flow to emit values for Views
     */
    private val _paginationFlow: Flow<PagingData<T>> by lazy {
        fetchContent(initialLoadSize).cachedIn(viewModelScope)
    }

    /**
     * Visible flow to be used at Views
     */
    val pagingFlow: Flow<PagingData<T>> by lazy { _paginationFlow }

    /**
     * Function which will implement pagination network call
     */
    abstract fun fetchContent(initialPageSize: Int): Flow<PagingData<T>>
}