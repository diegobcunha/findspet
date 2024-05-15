package br.com.warren.nebraska.tokens.sizes

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Spacing(
    val x75: Dp,
    val x150: Dp,
    val x300: Dp,
    val x350: Dp,
    val x400: Dp,
    val x450: Dp,
    val x500: Dp,
    val x600: Dp,
    val x700: Dp,
    val x800: Dp,
    val x900: Dp,
    val x1000: Dp,
    val x1100: Dp,
    val x1200: Dp,
) {
    companion object {
        val default = Spacing(
            x75 = 2.dp,
            x150 = 4.dp,
            x300 = 8.dp,
            x350 = 12.dp,
            x400 = 16.dp,
            x450 = 20.dp,
            x500 = 24.dp,
            x600 = 32.dp,
            x700 = 40.dp,
            x800 = 48.dp,
            x900 = 56.dp,
            x1000 = 64.dp,
            x1100 = 72.dp,
            x1200 = 80.dp
        )
    }
}