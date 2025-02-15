package com.example.departmentalresourcemanagement.features.settings.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.settings.ui.screens.SettingsScreen

fun NavController.navigateToSettingsScreen() {
    navigate(SettingsNavigation.SettingsScreen.route)
}

fun NavGraphBuilder.settingsNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = SettingsNavigation.SettingsScreen.route,
        route = SettingsNavigation.SettingsBase.route,
    ) {
        settingsScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.settingsScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = SettingsNavigation.SettingsScreen.route,
    ) {
        SettingsScreen(navigateBack)
    }
}
