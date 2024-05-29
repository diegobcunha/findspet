package com.diegocunha.datasource.model.response

data class PetPictureAttributeFormat(
    val large: PetPictureAttributeFormatSize,
    val medium: PetPictureAttributeFormatSize,
    val small: PetPictureAttributeFormatSize,
    val thumbnail: PetPictureAttributeFormatSize
)
