package com.diegocunha.navigation.route

sealed class FindPetRoute(val route: String) {
    object Home: FindPetRoute("home")
}