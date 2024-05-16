package com.diegocunha.coreui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.diegocunha.coreui.theme.PetsTheme

@Composable
fun CardBox(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(modifier = modifier) {
        Card(
            modifier = Modifier
                .background(PetsTheme.colors.primaryContainer)
                .fillMaxSize(),
            shape = RoundedCornerShape(size = 8.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            onClick = onClick
        ) {
            content()
        }
    }
}