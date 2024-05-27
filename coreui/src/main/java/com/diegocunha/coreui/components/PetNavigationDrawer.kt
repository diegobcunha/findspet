package com.diegocunha.coreui.components

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable

@Composable
fun <T : DefaultNavigation> PetNavigationDrawer(
    drawerState: DrawerState,
    menuItems: List<AppDrawerItemInfo<T>>,
    onItemClick: (T) -> Unit,
    currentItem: AppDrawerItemInfo<T>,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                drawerState = drawerState,
                menuItems = menuItems,
                currentItem = currentItem.drawerOption,
                onClick = onItemClick
            )
        },
        content = content
    )

}