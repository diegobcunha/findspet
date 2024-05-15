package com.diegocunha.coreui.tokens.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Immutable
data class PetsTypography(
    val d1: TextStyle,
    val d2: TextStyle,
    val d3: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val p1: TextStyle,
    val p2: TextStyle,
    val p3: TextStyle,
    val p4: TextStyle,
    val p5: TextStyle,
    val p6: TextStyle,
    val u1: TextStyle,
    val u2: TextStyle
) {
    companion object {
        val default = PetsTypography(
            d1 = TextStyle(
                fontSize = TypographySizes.TextSize.x1300,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                lineHeight = TypographySizes.LineHeight.x1000
            ),

            d2 = TextStyle(
                fontSize = TypographySizes.TextSize.x1200,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                lineHeight = TypographySizes.LineHeight.x900
            ),
            d3 = TextStyle(
                fontSize = TypographySizes.TextSize.x1100,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                lineHeight = TypographySizes.LineHeight.x800
            ),

            h1 = TextStyle(
                fontSize = TypographySizes.TextSize.x1000,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                lineHeight = TypographySizes.LineHeight.x700,
            ),

            h2 = TextStyle(
                fontSize = TypographySizes.TextSize.x800,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                lineHeight = TypographySizes.LineHeight.x600,
            ),

            h3 = TextStyle(
                fontSize = TypographySizes.TextSize.x600,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                lineHeight = TypographySizes.LineHeight.x500,
            ),

            p1 = TextStyle(
                fontSize = TypographySizes.TextSize.x900,
                fontFamily = PetsText,
                fontWeight = FontWeight.Normal,
                lineHeight = TypographySizes.LineHeight.x700,
            ),

            p2 = TextStyle(
                fontSize = TypographySizes.TextSize.x700,
                fontFamily = PetsText,
                fontWeight = FontWeight.Normal,
                lineHeight = TypographySizes.LineHeight.x600
            ),
            p3 = TextStyle(
                fontSize = TypographySizes.TextSize.x500,
                fontFamily = PetsText,
                fontWeight = FontWeight.Normal,
                lineHeight = TypographySizes.LineHeight.x500
            ),

            p4 = TextStyle(
                fontSize = TypographySizes.TextSize.x400,
                fontFamily = PetsText,
                fontWeight = FontWeight.Normal,
                lineHeight = TypographySizes.LineHeight.x400
            ),

            p5 = TextStyle(
                fontSize = TypographySizes.TextSize.x300,
                fontFamily = PetsText,
                fontWeight = FontWeight.Normal,
                lineHeight = TypographySizes.LineHeight.x300
            ),

            p6 = TextStyle(
                fontSize = TypographySizes.TextSize.x100,
                fontFamily = PetsText,
                fontWeight = FontWeight.Normal,
                lineHeight = TypographySizes.LineHeight.x100
            ),

            u1 = TextStyle(
                fontSize = TypographySizes.TextSize.x400,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                lineHeight = TypographySizes.LineHeight.x300
            ),

            u2 = TextStyle(
                fontSize = TypographySizes.TextSize.x200,
                fontFamily = PetsText,
                fontWeight = FontWeight.Bold,
                lineHeight = TypographySizes.LineHeight.x200,
            )
        )
    }
}