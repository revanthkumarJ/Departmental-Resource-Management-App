package com.example.departmentalresourcemanagement

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun DepartmentNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.MainGraph.route
    ) {
        mainGraph(navController)
        authGraph(navController)
    }
}

sealed class NavRoutes(val route: String) {
    data object MainGraph : NavRoutes("main_graph")
    data object Home : NavRoutes("home")
    data object Profile : NavRoutes("profile")
    data object Login : NavRoutes("login")
    data object Register : NavRoutes("register")
}

fun NavGraphBuilder.mainGraph(navController: NavHostController) {
    composable(NavRoutes.Home.route) {
        // HomeScreen(navController)
    }
    composable(NavRoutes.Profile.route) {
        // ProfileScreen(navController)
    }
}

fun NavGraphBuilder.authGraph(navController: NavHostController) {
    composable(NavRoutes.Login.route) {
        // LoginScreen(navController)
    }
    composable(NavRoutes.Register.route) {
        // RegisterScreen(navController)
    }
}
