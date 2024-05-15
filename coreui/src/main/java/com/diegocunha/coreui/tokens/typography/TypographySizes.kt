package com.diegocunha.coreui.tokens.typography

import androidx.compose.ui.unit.sp

internal sealed class TypographySizes {
    object TextSize {
        val x100 = 12.sp
        val x200 = 13.sp
        val x300 = 15.sp
        val x400 = 17.sp
        val x500 = 19.sp
        val x600 = 21.sp
        val x700 = 23.sp
        val x800 = 26.sp
        val x900 = 31.sp
        val x1000 = 34.sp
        val x1100 = 43.sp
        val x1200 = 60.sp
        val x1300 = 77.sp
    }

    object LineHeight {
        val x100 = 16.sp
        val x200 = 18.sp
        val x300 = 24.sp
        val x400 = 26.sp
        val x500 = 28.sp
        val x600 = 32.sp
        val x700 = 40.sp
        val x800 = 48.sp
        val x900 = 64.sp
        val x1000 = 80.sp
    }
}
