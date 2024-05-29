package com.diegocunha.petdetail.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.diegocunha.coreui.components.GetCrossfade
import org.koin.androidx.compose.navigation.koinNavViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun PetDetailScreen(id: Long) {
    val viewModel = koinNavViewModel<PetDetailViewModel>() {
        parametersOf(id)
    }
    val state by viewModel.stateFlow.collectAsState()

    GetCrossfade(
        state = state,
        initial = {
            Text(text = "Loading")
        },
        failure = {}) {
        Text(text = it.name.orEmpty())
    }

}