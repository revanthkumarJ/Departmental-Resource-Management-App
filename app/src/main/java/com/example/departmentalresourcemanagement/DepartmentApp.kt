package com.example.departmentalresourcemanagement

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import com.example.departmentalresourcemanagement.features.GoogleSignInScreen
import com.example.departmentalresourcemanagement.features.home.ui.screens.HomeContent
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DepartmentApp(
    onClickLogout: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var user by remember { mutableStateOf(FirebaseAuth.getInstance().currentUser) }

    DisposableEffect(Unit) {
        val auth = FirebaseAuth.getInstance()
        val authListener = FirebaseAuth.AuthStateListener { updatedAuth ->
            user = updatedAuth.currentUser
        }
        auth.addAuthStateListener(authListener)

        onDispose {
            auth.removeAuthStateListener(authListener)
        }
    }

    DepartmentBackground(modifier) {
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            modifier = Modifier.semantics {
                testTagsAsResourceId = true
            },
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            snackbarHost = { SnackbarHost(snackbarHostState) },
        ) { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    ),
            ) {
                if (user == null) {
                    GoogleSignInScreen(onSignInSuccess = {
                        user = FirebaseAuth.getInstance().currentUser
                    })
                } else {
                    DepartmentNavHost(
                        onClickLogout = {
                            FirebaseAuth.getInstance().signOut()

                            user = null
                        },
                        modifier = Modifier,
                    )
                }
            }
        }
    }
}
