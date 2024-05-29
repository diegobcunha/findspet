package com.diegocunha.petdetail.datasource.repository

import com.diegocunha.datasource.model.response.PetDetailResponse

interface PetDetailRepository {

    suspend fun getPetDetail(id: Long): Result<PetDetailResponse>
}