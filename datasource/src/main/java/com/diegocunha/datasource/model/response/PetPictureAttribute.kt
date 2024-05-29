package com.diegocunha.datasource.model.response

data class PetPictureAttribute(
    val formats: PetPictureAttributeFormat,
    val caption: String? = null
)
