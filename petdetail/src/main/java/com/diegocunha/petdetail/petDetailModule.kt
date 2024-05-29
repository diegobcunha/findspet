package com.diegocunha.petdetail

import com.diegocunha.petdetail.ui.detail.PetDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val petDetailModule = module {

    viewModel { (petId: Long)  -> PetDetailViewModel(get(), petId) }
}