package com.diegocunha.discoverypet.datasource.model.response

import com.google.gson.annotations.SerializedName

enum class PetStatus {

    @SerializedName("Em busca")
    MISSED,
    @SerializedName("Procura-se dono")
    SEARCH_OWNER
}