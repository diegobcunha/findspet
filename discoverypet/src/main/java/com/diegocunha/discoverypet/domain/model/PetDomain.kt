package com.diegocunha.discoverypet.domain.model

data class PetDomain(
    val name: String?,
    val image: String,
    val type: PetTypeDomain,
    val statusDomain: PetStatusDomain,
    val city: String
)
