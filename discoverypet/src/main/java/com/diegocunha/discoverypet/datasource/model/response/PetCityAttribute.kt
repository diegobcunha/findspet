package com.diegocunha.discoverypet.datasource.model.response

import com.google.gson.annotations.SerializedName

data class PetCityAttribute(
    @SerializedName("nome")
    val name: String
)
