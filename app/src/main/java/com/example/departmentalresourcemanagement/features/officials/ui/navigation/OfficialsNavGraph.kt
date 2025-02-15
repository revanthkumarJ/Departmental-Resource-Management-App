package com.example.departmentalresourcemanagement.features.officials.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.about.ui.navigation.AboutNavigation
import com.example.departmentalresourcemanagement.features.about.ui.screens.AboutScreen
import com.example.departmentalresourcemanagement.features.officials.ui.screens.OfficialsScreen

fun NavController.navigateToOfficialsScreen() {
    navigate(OfficialsNavigation.OfficialsScreen.route)
}

fun NavGraphBuilder.officialsNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = OfficialsNavigation.OfficialsScreen.route,
        route = OfficialsNavigation.OfficialsBase.route,
    ) {
        officialsScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.officialsScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = OfficialsNavigation.OfficialsScreen.route,
    ) {
        OfficialsScreen(navigateBack)
    }
}
