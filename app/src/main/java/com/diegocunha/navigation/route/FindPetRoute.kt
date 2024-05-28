package com.diegocunha.navigation.route

import com.diegocunha.coreui.components.DefaultNavigation

sealed interface FindPetRoute : DefaultNavigation {
    data object Home : FindPetRoute {
        override val route = "Home"
    }

    data object About : FindPetRoute {
        override val route = "About"
    }

    data object PetDetail : FindPetRoute {
        override val route = "Detail/{id}"
    }
}

fun FindPetRoute.PetDetail.navigate(id: Long) = route.replace("{$DEFAULT_ID_FIELD}", id.toString())

const val DEFAULT_ID_FIELD = "id"