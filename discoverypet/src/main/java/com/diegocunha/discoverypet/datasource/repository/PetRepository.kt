package com.diegocunha.discoverypet.datasource.repository

import androidx.paging.PagingData
import com.diegocunha.discoverypet.datasource.model.response.Pet
import kotlinx.coroutines.flow.Flow

interface PetRepository {

    fun searchPets(initialSize: Int): Flow<PagingData<Pet>>
}