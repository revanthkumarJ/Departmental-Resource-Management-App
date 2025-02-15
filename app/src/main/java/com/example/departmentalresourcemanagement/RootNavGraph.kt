package com.example.departmentalresourcemanagement

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
internal fun RootNavGraph(
    navHostController: NavHostController,
    startDestination: String,
    onClickLogout: () -> Unit,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination,
        route = RevanthNavGraph.ROOT_GRAPH,
        modifier = modifier,
    ) {

        composable(RevanthNavGraph.MAIN_GRAPH) {
            DepartmentApp(
                onClickLogout = onClickLogout,
            )
        }
    }
}
