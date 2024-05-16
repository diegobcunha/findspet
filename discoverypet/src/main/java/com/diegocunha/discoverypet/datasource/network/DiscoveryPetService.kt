package com.diegocunha.discoverypet.datasource.network

import com.diegocunha.discoverypet.datasource.model.response.PetResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoveryPetService {

    @GET("pets")
    suspend fun getPets(
        @Query("pagination[page]") page: Int,
        @Query("pagination[pageSize]") pageSize: Int,
        @Query("populate") populate: String = "foto,cidade",
        @Query("sort")sort: String = "createdAt:desc"
    ): PetResponse
}