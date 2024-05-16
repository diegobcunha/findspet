package com.diegocunha.discoverypet.datasource.model.response

import com.google.gson.annotations.SerializedName

enum class PetType {
    @SerializedName("Cão")
    DOG,
    @SerializedName("Gato")
    CAT
}
