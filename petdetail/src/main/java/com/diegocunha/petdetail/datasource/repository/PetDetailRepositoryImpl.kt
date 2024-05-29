package com.diegocunha.petdetail.datasource.repository

import com.diegocunha.datasource.model.response.PetDetailResponse
import com.diegocunha.datasource.network.network.DiscoveryPetService

class PetDetailRepositoryImpl(
    private val service: DiscoveryPetService
) : PetDetailRepository {

    override suspend fun getPetDetail(id: Long): Result<PetDetailResponse> =
        service.getPetDetail(id)
}