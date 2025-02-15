package com.example.departmentalresourcemanagement.features.timetable.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.departmentalresourcemanagement.features.timetable.ui.screens.TimeTableScreen


fun NavController.navigateToTimeTableScreen() {
    navigate(TimeTableNavigation.TimeTableScreen.route)
}

fun NavGraphBuilder.timeTableNavGraph(
    navigateBack: () -> Unit,
) {
    navigation(
        startDestination = TimeTableNavigation.TimeTableScreen.route,
        route = TimeTableNavigation.TimeTableBase.route,
    ) {
        timeTableScreenRoute(
            navigateBack = navigateBack
        )
    }
}

fun NavGraphBuilder.timeTableScreenRoute(
    navigateBack: () -> Unit,
) {
    composable(
        route = TimeTableNavigation.TimeTableScreen.route,
    ) {
        TimeTableScreen(navigateBack)
    }
}
