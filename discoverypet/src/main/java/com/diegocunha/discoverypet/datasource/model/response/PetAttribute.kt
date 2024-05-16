package com.diegocunha.discoverypet.datasource.model.response

import com.google.gson.annotations.SerializedName

data class PetAttribute(
    @SerializedName("tipo")
    val type: PetType?,
    @SerializedName("nome")
    val name: String?,
    @SerializedName("nomeContato")
    val contactName: String,
    @SerializedName("telefoneContato")
    val contactPhone: String? = null,
    @SerializedName("foto")
    val picture: PetPicture,
    @SerializedName("cidade")
    val city: PetCity?
)
