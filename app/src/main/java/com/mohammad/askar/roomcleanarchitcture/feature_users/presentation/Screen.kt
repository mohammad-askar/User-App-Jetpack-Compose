package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation

sealed class Screen(
    val route: String
) {
    object Home : Screen(route = "home")
    object Edit : Screen(route = "edit?userId={userId}") {

        fun passId(userId: Int?): String {
            return "edit?userId=$userId"
        }
    }
}
