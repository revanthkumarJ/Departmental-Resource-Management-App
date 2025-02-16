package com.example.departmentalresourcemanagement

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.departmentalresourcemanagement.features.about.ui.navigation.aboutNavGraph
import com.example.departmentalresourcemanagement.features.about.ui.navigation.navigateToAboutScreen
import com.example.departmentalresourcemanagement.features.cr.ui.navigation.crNavGraph
import com.example.departmentalresourcemanagement.features.cr.ui.navigation.navigateToCRScreen
import com.example.departmentalresourcemanagement.features.crprofiles.ui.navigation.crProfileNavGraph
import com.example.departmentalresourcemanagement.features.crprofiles.ui.navigation.navigateToCrProfileScreen
import com.example.departmentalresourcemanagement.features.faculty.ui.navigation.facultyNavGraph
import com.example.departmentalresourcemanagement.features.faculty.ui.navigation.navigateToFacultyScreen
import com.example.departmentalresourcemanagement.features.hod.ui.navigation.hodNavGraph
import com.example.departmentalresourcemanagement.features.hod.ui.navigation.navigateToHodScreen
import com.example.departmentalresourcemanagement.features.home.ui.navigation.HomeDestinations
import com.example.departmentalresourcemanagement.features.home.ui.navigation.homeNavGraph
import com.example.departmentalresourcemanagement.features.officials.ui.navigation.navigateToOfficialsScreen
import com.example.departmentalresourcemanagement.features.officials.ui.navigation.officialsNavGraph
import com.example.departmentalresourcemanagement.features.settings.ui.navigation.navigateToSettingsScreen
import com.example.departmentalresourcemanagement.features.settings.ui.navigation.settingsNavGraph
import com.example.departmentalresourcemanagement.features.timetable.ui.navigation.navigateToTimeTableScreen
import com.example.departmentalresourcemanagement.features.timetable.ui.navigation.timeTableNavGraph


@Composable
fun DepartmentNavHost(
    onClickLogout: () -> Unit,
    modifier: Modifier
) {

    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RevanthNavGraph.MAIN_GRAPH,
        modifier = modifier
    ) {
        homeNavGraph(
            onNavigate = { handleHomeNavigation(navController, it, onClickLogout, context) }
        )
        aboutNavGraph (navigateBack = navController::popBackStack)
        timeTableNavGraph(navigateBack = navController::popBackStack)
        settingsNavGraph(navigateBack = navController::popBackStack)
        crNavGraph(navigateBack = navController::popBackStack)
        hodNavGraph(navigateBack = navController::popBackStack)
        officialsNavGraph(navigateBack = navController::popBackStack)
        facultyNavGraph (navigateBack = navController::popBackStack)
        crProfileNavGraph(navigateBack = navController::popBackStack)
    }
}

sealed class NavRoutes(val route: String) {
    data object MainGraph : NavRoutes("main_graph")
    data object Home : NavRoutes("home")
    data object Profile : NavRoutes("profile")
    data object Login : NavRoutes("login")
}



fun handleHomeNavigation(
    navController: NavHostController,
    homeDestinations: HomeDestinations,
    onClickLogout: () -> Unit,
    context: Context,
) {
    when (homeDestinations) {
        HomeDestinations.HOME -> Unit
        HomeDestinations.APP_INFO -> openAppInfo(context)
        HomeDestinations.SETTINGS -> navController.navigateToSettingsScreen()
        HomeDestinations.ABOUT_US -> navController.navigateToAboutScreen()
        HomeDestinations.LOGOUT -> onClickLogout()
        HomeDestinations.NOTIFICATIONS -> Log.d("Navigation", "Notifications Clicked")
        HomeDestinations.PROFILE -> navController.navigate(NavRoutes.Profile.route)
        HomeDestinations.CR -> navController.navigateToCRScreen()
        HomeDestinations.FACULTY -> navController.navigateToFacultyScreen()
        HomeDestinations.HOD -> navController.navigateToHodScreen()
        HomeDestinations.OFFICIALS -> navController.navigateToOfficialsScreen()
        HomeDestinations.Timetable -> navController.navigateToTimeTableScreen()
        HomeDestinations.CRS_PROFILES -> navController.navigateToCrProfileScreen()
    }
}

fun <T : Activity> startActivity(context: Context, clazz: Class<T>) {
    context.startActivity(Intent(context, clazz))
}

private fun openAppInfo(context: Context) {
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
        data = Uri.parse("package:${context.packageName}")
    }
    context.startActivity(intent)
}

internal object RevanthNavGraph {
    const val ROOT_GRAPH = "root_graph"
    const val AUTH_GRAPH = "auth_graph"
    const val PASSCODE_GRAPH = "passcode_graph"
    const val MAIN_GRAPH = "main_graph"
}