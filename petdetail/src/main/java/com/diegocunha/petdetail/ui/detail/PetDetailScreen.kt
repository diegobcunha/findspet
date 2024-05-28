package com.diegocunha.petdetail.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PetDetailScreen(id: Long) {
    Text(text = id.toString())
}