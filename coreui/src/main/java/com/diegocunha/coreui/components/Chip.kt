package com.diegocunha.coreui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ChipColors
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.diegocunha.coreui.theme.PetsTheme

@Composable
fun StatusChip(
    modifier: Modifier = Modifier,
    text: String,
    colors: ChipColors
) {
    RoundedChip(
        modifier = modifier,
        text = text,
        colors = colors,
        onClick = {}
    )
}

@Composable
fun RoundedChip(
    modifier: Modifier = Modifier,
    text: String,
    colors: ChipColors = SuggestionChipDefaults.suggestionChipColors(),
    onClick: () -> Unit
) {
    SuggestionChip(
        modifier = modifier,
        onClick = onClick,
        label = { Text(text = text) },
        shape = RoundedCornerShape(PetsTheme.sizes.spacing.x400),
        colors = colors
    )
}