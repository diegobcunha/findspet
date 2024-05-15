package com.diegocunha.coreui.tokens.typography

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.diegocunha.coreui.R

private val petsFontList = listOf(
    Font(R.font.montserrat_regular, FontWeight.W400, FontStyle.Normal),
    Font(R.font.montserrat_italic, FontWeight.W400, FontStyle.Italic),
    Font(R.font.montserrat_bold, FontWeight.W700, FontStyle.Normal)
)

val PetsText = FontFamily(petsFontList)