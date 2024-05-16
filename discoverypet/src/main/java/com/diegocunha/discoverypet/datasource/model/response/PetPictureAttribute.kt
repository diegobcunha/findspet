package com.diegocunha.discoverypet.datasource.model.response

data class PetPictureAttribute(
    val formats: PetPictureAttributeFormat,
    val caption: String? = null
)
