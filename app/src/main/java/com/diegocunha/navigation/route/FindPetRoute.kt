package com.diegocunha.navigation.route

import com.diegocunha.coreui.components.DefaultNavigation

sealed class FindPetRoute : DefaultNavigation {
    data object Home : FindPetRoute() {
        override val route = "Home"
    }

    data object About : FindPetRoute() {
        override val route = "About"
    }
}