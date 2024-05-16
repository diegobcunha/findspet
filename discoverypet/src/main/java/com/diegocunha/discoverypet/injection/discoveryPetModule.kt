package com.diegocunha.discoverypet.injection

import com.diegocunha.datasource.retrofit
import com.diegocunha.discoverypet.datasource.network.DiscoveryPetService
import com.diegocunha.discoverypet.datasource.repository.PetRepository
import com.diegocunha.discoverypet.datasource.repository.PetRepositoryImpl
import com.diegocunha.discoverypet.domain.usecase.FindPetUseCase
import org.koin.dsl.module

val discoveryPetModule = module {
    single { retrofit(get()).create(DiscoveryPetService::class.java) }

    factory<PetRepository> { PetRepositoryImpl(get()) }

    factory { FindPetUseCase(get()) }
}