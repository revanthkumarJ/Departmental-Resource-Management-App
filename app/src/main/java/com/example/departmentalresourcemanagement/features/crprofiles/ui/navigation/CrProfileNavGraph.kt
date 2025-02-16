package com.example.departmentalresourcemanagement.features.crprofiles.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.crprofiles.ui.screens.CrProfileScreen


fun NavController.navigateToCrProfileScreen() {
    navigate(CrProfileNavigation.CrProfileScreen.route)
}

fun NavGraphBuilder.crProfileNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = CrProfileNavigation.CrProfileScreen.route,
        route = CrProfileNavigation.CrProfileBase.route,
    ) {
        crProfileScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.crProfileScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = CrProfileNavigation.CrProfileScreen.route,
    ) {
        CrProfileScreen(navigateBack=navigateBack)
    }
}