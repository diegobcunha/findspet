package com.diegocunha.coreui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.diegocunha.coreui.tokens.colors.darkScheme
import com.diegocunha.coreui.tokens.colors.lightScheme
import com.diegocunha.coreui.tokens.sizes.PetsSizes
import com.diegocunha.coreui.tokens.typography.PetsTypography

@Composable
fun PetsTheme(
    colors: ColorScheme = defaultColorsBySystem(),
    typography: PetsTypography = PetsTypography.default,
    sizes: PetsSizes = PetsSizes.default,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalPetsColors provides colors,
        LocalPetsTypography provides typography,
        LocalPetsSizes provides sizes
    ) {
        MaterialTheme(
            colorScheme = colors,
            typography = PetsTheme.typography.materialTypo,
            shapes = PetsTheme.sizes.materialSizes,
        ) {
            val view = LocalView.current
            if (!view.isInEditMode) {
                SideEffect {
                    val window = (view.context as Activity).window
                    window.statusBarColor = colors.primary.toArgb()
                    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
                }
            }

            content()
        }
    }
}

@Composable
private fun defaultColorsBySystem(): ColorScheme {
    return if (isSystemInDarkTheme()) {
        lightScheme
    } else {
        darkScheme
    }
}

object PetsTheme {

    val colors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalPetsColors.current

    val typography: PetsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalPetsTypography.current

    val sizes: PetsSizes
        @Composable
        @ReadOnlyComposable
        get() = LocalPetsSizes.current

//    val icons: PetsIcons
//        @Composable
//        @ReadOnlyComposable
//        get() = LocalPetsIcons.current
}

val PetsTypography.materialTypo
    get() = Typography(
        displayLarge = h2,
        displayMedium = h3,
        displaySmall = h3,
        headlineMedium = h3,
        headlineSmall = h3,
        titleLarge = h3,
        titleMedium = p3,
        titleSmall = p4,
        bodyLarge = p3,
        bodyMedium = p5,
        labelLarge = u1,
        labelMedium = p6,
        labelSmall = p3
    )

val PetsSizes.materialSizes: Shapes
    get() = Shapes(
        small = RoundedCornerShape(radius.x200),
        medium = RoundedCornerShape(radius.x400),
        large = RoundedCornerShape(radius.x400)
    )