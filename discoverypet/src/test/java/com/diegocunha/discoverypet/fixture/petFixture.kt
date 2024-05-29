package com.diegocunha.discoverypet.fixture

import com.diegocunha.datasource.model.response.Pet
import com.diegocunha.datasource.model.response.PetAttribute
import com.diegocunha.datasource.model.response.PetCity
import com.diegocunha.datasource.model.response.PetCityAttribute
import com.diegocunha.datasource.model.response.PetCityData
import com.diegocunha.datasource.model.response.PetMeta
import com.diegocunha.datasource.model.response.PetPagination
import com.diegocunha.datasource.model.response.PetPicture
import com.diegocunha.datasource.model.response.PetPictureAttribute
import com.diegocunha.datasource.model.response.PetPictureAttributeFormat
import com.diegocunha.datasource.model.response.PetPictureAttributeFormatSize
import com.diegocunha.datasource.model.response.PetPictureData
import com.diegocunha.datasource.model.response.PetResponse
import com.diegocunha.datasource.model.response.PetStatus
import com.diegocunha.datasource.model.response.PetType

val petCityAttribute = PetCityAttribute(
    name = "name"
)

val petCityData = PetCityData(
    petCityAttribute
)

val petCity = PetCity(
    petCityData
)

val imageSize = PetPictureAttributeFormatSize(
    url = "url"
)
val petPictureAttributeFormat = PetPictureAttributeFormat(
    large = imageSize,
    medium = imageSize,
    small = imageSize,
    thumbnail = imageSize
)

val petPictureAttribute = PetPictureAttribute(
    formats = petPictureAttributeFormat
)

val petPictureData = PetPictureData(
    1L,
    petPictureAttribute
)

val petPicture = PetPicture(
    listOf(petPictureData)
)

val petAttribute = PetAttribute(
    type = PetType.DOG,
    name = "name",
    contactName = "contactName",
    contactPhone = "contactPhone",
    picture = petPicture,
    status = PetStatus.MISSED,
    city = petCity
)

val pet = Pet(
    1L,
    petAttribute
)

val petList = listOf(pet)

val petPagination = PetPagination(
    1L,
    10L,
    1,
    1
)

val petMeta = PetMeta(
    petPagination
)

val petResponse = PetResponse(
    petList,
    petMeta
)