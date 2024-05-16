package com.diegocunha.discoverypet.domain.usecase

import androidx.paging.PagingData
import com.diegocunha.datasource.extensions.transformPagingData
import com.diegocunha.discoverypet.datasource.repository.PetRepository
import com.diegocunha.discoverypet.domain.model.PetDomain
import kotlinx.coroutines.flow.Flow

class FindPetUseCase(
    private val repository: PetRepository
) {

    operator fun invoke(initialSize: Int): Flow<PagingData<PetDomain>> =
        repository.searchPets(initialSize).transformPagingData {
            PetDomain(it.attributes.picture.data.first().attributes.formats.thumbnail.url)
        }
}