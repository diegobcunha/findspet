package com.diegocunha.discoverypet.datasource.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.diegocunha.discoverypet.datasource.network.DiscoveryPetService
import com.diegocunha.discoverypet.datasource.repository.source.PetSource

class PetRepositoryImpl(
    private val api: DiscoveryPetService,
) : PetRepository {

    override suspend fun searchPets() = Pager(
        PagingConfig(
            pageSize = 1,
            prefetchDistance = 2,
            initialLoadSize = 12
        )
    ) { PetSource(api) }.flow
}