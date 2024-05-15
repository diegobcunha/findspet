package br.com.warren.nebraska.tokens.sizes

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Radius(
    val x100: Dp,
    val x200: Dp,
    val x300: Dp,
    val x400: Dp,
    val max: Dp
) {

    companion object {
        val default = Radius(
            x100 = 4.dp,
            x200 = 8.dp,
            x300 = 12.dp,
            x400 = 16.dp,
            max = 1000.dp
        )
    }

}