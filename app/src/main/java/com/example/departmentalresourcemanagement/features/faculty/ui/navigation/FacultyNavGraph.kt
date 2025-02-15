package com.example.departmentalresourcemanagement.features.faculty.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.faculty.ui.screens.FacultyScreen

fun NavController.navigateToFacultyScreen() {
    navigate(FacultyNavigation.FacultyScreen.route)
}

fun NavGraphBuilder.facultyNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = FacultyNavigation.FacultyScreen.route,
        route = FacultyNavigation.FacultyBase.route,
    ) {
        facultyScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.facultyScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = FacultyNavigation.FacultyScreen.route,
    ) {
        FacultyScreen(navigateBack)
    }
}
