package com.diegocunha.discoverypet.domain.usecase

import androidx.paging.PagingData
import com.diegocunha.datasource.extensions.transformPagingData
import com.diegocunha.discoverypet.datasource.model.response.PetStatus
import com.diegocunha.discoverypet.datasource.model.response.PetType
import com.diegocunha.discoverypet.datasource.repository.PetRepository
import com.diegocunha.discoverypet.domain.model.PetDomain
import com.diegocunha.discoverypet.domain.model.PetStatusDomain
import com.diegocunha.discoverypet.domain.model.PetTypeDomain
import kotlinx.coroutines.flow.Flow

class FindPetUseCase(
    private val repository: PetRepository
) {

    operator fun invoke(initialSize: Int): Flow<PagingData<PetDomain>> =
        repository.searchPets(initialSize).transformPagingData {
            PetDomain(
                name = it.attributes.name,
                image = it.attributes.picture.data.first().attributes.formats.thumbnail.url,
                type = it.attributes.type.toDomain(),
                statusDomain = it.attributes.status.toDomain(),
                city = it.attributes.city.data.attributes.name
            )
        }

    private fun PetType.toDomain() = when (this) {
        PetType.DOG -> PetTypeDomain.DOG
        PetType.CAT -> PetTypeDomain.CAT
    }

    private fun PetStatus.toDomain() = when (this) {
        PetStatus.MISSED -> PetStatusDomain.MISSED
        PetStatus.SEARCH_OWNER -> PetStatusDomain.SEARCH_OWNER
    }
}