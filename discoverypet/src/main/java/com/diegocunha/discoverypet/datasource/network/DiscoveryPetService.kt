package com.diegocunha.discoverypet.datasource.network

import com.diegocunha.discoverypet.datasource.model.response.PetResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoveryPetService {

    @GET("5&pagination[page]=5&pagination[pageSize]=12&populate=foto,cidade&sort=createdAt:desc")
    suspend fun getPets(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ) : PetResponse
}