package com.diegocunha.discoverypet.ui.home

data class PetUi(
    val image: String,
    val type: PetUiType,
    val status: PetUiStatus,
    val city: String
)

enum class PetUiStatus {
    MISSED,
    SEARCH
}

enum class PetUiType {
    DOG,
    CAT
}