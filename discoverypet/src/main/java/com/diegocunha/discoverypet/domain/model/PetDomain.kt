package com.diegocunha.discoverypet.domain.model

data class PetDomain(
    val image: String,
    val type: PetTypeDomain,
    val statusDomain: PetStatusDomain,
    val city: String
)
