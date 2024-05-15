package com.diegocunha.coreui.tokens.sizes

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Border(
    val x400: Dp,
    val x500: Dp,
    val x600: Dp
) {
    companion object {
        val default = Border(
            x400 = 1.dp,
            x500 = 2.dp,
            x600 = 3.dp
        )
    }
}