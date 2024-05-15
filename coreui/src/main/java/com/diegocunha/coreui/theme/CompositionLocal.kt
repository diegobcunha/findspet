package com.diegocunha.coreui.theme

import androidx.compose.runtime.compositionLocalOf
import com.diegocunha.coreui.tokens.colors.lightScheme
import com.diegocunha.coreui.tokens.sizes.PetsSizes
import com.diegocunha.coreui.tokens.typography.PetsTypography

val LocalPetsColors = compositionLocalOf {
    lightScheme
}

val LocalPetsTypography = compositionLocalOf {
    PetsTypography.default
}

val LocalPetsSizes = compositionLocalOf {
    PetsSizes.default
}

val LocalPetsIcons = compositionLocalOf {
//    PetsIcons.default
}