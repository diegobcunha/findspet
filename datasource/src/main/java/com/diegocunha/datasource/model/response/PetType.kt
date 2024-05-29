package com.diegocunha.datasource.model.response

import com.google.gson.annotations.SerializedName

enum class PetType {
    @SerializedName("Cão")
    DOG,
    @SerializedName("Gato")
    CAT
}
