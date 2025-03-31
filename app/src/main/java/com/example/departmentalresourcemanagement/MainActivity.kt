package com.example.departmentalresourcemanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.departmentalresourcemanagement.RevanthNavGraph.MAIN_GRAPH
import com.example.departmentalresourcemanagement.features.home.ui.screens.HomeContent
import com.example.departmentalresourcemanagement.ui.theme.DepartmentalResourceManagementTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()

        setContent {
            val darkTheme = isSystemInDarkTheme()
            val lightScrim = Color(0x80FFFFFF)
            val darkScrim = Color(0x80000000)
            DisposableEffect(darkTheme) {
                window?.statusBarColor = if (darkTheme) darkScrim.toArgb() else lightScrim.toArgb()
                window?.navigationBarColor = if (darkTheme) darkScrim.toArgb() else lightScrim.toArgb()
                onDispose {}
            }
            val navController = rememberNavController()
            DepartmentalResourceManagementTheme {

                    RootNavGraph(onClickLogout = {
                        FirebaseAuth.getInstance().signOut()
                        navController.navigate(NavRoutes.Login.route) {
                            popUpTo(RevanthNavGraph.MAIN_GRAPH) { inclusive = true }
                        }
                    },navHostController = navController,startDestination = MAIN_GRAPH)
            }

        }
    }
}

