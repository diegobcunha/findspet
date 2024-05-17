package com.diegocunha.coreui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.diegocunha.coreui.theme.PetsTheme

@Composable
fun Chip(
    color: Color,
    contentColor: Color,
    modifier: Modifier = Modifier,
    configuration: ChipConfiguration = ChipDefaults.Large,
    content: @Composable (BoxScope.() -> Unit)
) {
    var selected by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = modifier,
        color = color,
        contentColor = contentColor,
        shape = CircleShape
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(configuration.padding)
        ) {
            CompositionLocalProvider(LocalContentColor provides contentColor) {
                ProvideTextStyle(value = configuration.textStyle) {
                    content()
                }
            }
        }
    }
}

object ChipDefaults {

    val Large: ChipConfiguration
        @Composable get() = DefaultChipConfiguration(
            padding = PaddingValues(
                top = PetsTheme.sizes.spacing.x150,
                bottom = PetsTheme.sizes.spacing.x150,
                start = PetsTheme.sizes.spacing.x400,
                end = PetsTheme.sizes.spacing.x400
            ),
            textStyle = PetsTheme.typography.p3
        )

    val Small: ChipConfiguration
        @Composable get() = DefaultChipConfiguration(
            padding = PaddingValues(
                top = 2.dp,
                bottom = 2.dp,
                start = PetsTheme.sizes.spacing.x350,
                end = PetsTheme.sizes.spacing.x350
            ),
            textStyle = PetsTheme.typography.p6
        )

}

interface ChipConfiguration {

    val padding: PaddingValues

    val textStyle: TextStyle

}

private class DefaultChipConfiguration(
    override val padding: PaddingValues,
    override val textStyle: TextStyle
) : ChipConfiguration
