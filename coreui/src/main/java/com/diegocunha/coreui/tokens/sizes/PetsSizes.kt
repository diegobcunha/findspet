package com.diegocunha.coreui.tokens.sizes

import androidx.compose.runtime.Immutable
import br.com.warren.nebraska.tokens.sizes.Radius
import br.com.warren.nebraska.tokens.sizes.Spacing

@Immutable
data class PetsSizes(
    val spacing: Spacing,
    val border: Border,
    val radius: Radius
) {
    companion object {
        val default = PetsSizes(
            spacing = Spacing.default,
            border = Border.default,
            radius = Radius.default
        )
    }
}