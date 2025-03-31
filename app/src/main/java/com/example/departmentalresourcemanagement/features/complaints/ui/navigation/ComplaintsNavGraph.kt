package com.example.departmentalresourcemanagement.features.complaints.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.about.ui.navigation.AboutNavigation
import com.example.departmentalresourcemanagement.features.about.ui.screens.AboutScreen
import com.example.departmentalresourcemanagement.features.complaints.ui.screens.ComplaintsScreen


fun NavController.navigateToComplaintsScreen() {
    navigate(ComplaintsNavigation.ComplaintsScreen.route)
}

fun NavGraphBuilder.complaintsNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = ComplaintsNavigation.ComplaintsScreen.route,
        route = ComplaintsNavigation.ComplaintsBase.route,
    ) {
        complaintScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.complaintScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = ComplaintsNavigation.ComplaintsScreen.route,
    ) {
        ComplaintsScreen (navigateBack=navigateBack)
    }
}