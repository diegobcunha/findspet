package com.diegocunha.datasource.network.network

import com.diegocunha.datasource.model.response.PetDetailResponse
import com.diegocunha.datasource.model.response.PetResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DiscoveryPetService {

    @GET("pets")
    suspend fun getPets(
        @Query("pagination[page]") page: Int,
        @Query("pagination[pageSize]") pageSize: Int,
        @Query("populate") populate: String = "foto,cidade",
        @Query("sort") sort: String = "createdAt:desc"
    ): PetResponse

    @GET("pets/{id}")
    suspend fun getPetDetail(
        @Path("id") id: Long,
        @Query("populate") populate: String = "foto,cidade",
        @Query("sort") sort: String = "createdAt:desc"
    ): Result<PetDetailResponse>
}