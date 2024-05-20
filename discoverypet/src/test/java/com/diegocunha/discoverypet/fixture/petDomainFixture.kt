package com.diegocunha.discoverypet.fixture

import com.diegocunha.discoverypet.domain.model.PetDomain
import com.diegocunha.discoverypet.domain.model.PetStatusDomain
import com.diegocunha.discoverypet.domain.model.PetTypeDomain

val petDomain = PetDomain(
    "image",
    type = PetTypeDomain.DOG,
    statusDomain = PetStatusDomain.MISSED,
    "city"
)

val listDomain = listOf(petDomain)