package com.diegocunha.coreui.components

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class AppDrawerItemInfo<T>(
    val drawerOption: T,
    @StringRes val title: Int,
    val icon: ImageVector,
)
