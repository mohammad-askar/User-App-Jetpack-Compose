package com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.Screen
import com.mohammad.askar.roomcleanarchitcture.feature_users.presentation.home.HomeScreen

@Composable
fun NavHost() {
    val navController = rememberNavController()

    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Edit.route,
            arguments = listOf(
                navArgument(
                    name = "userId"
                ){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ){
            //EditScreen(navController = navController)
        }

    }
}