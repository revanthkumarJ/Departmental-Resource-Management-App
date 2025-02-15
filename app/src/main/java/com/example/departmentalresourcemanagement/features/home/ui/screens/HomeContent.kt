package com.example.departmentalresourcemanagement.features.home.ui.screens

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.features.home.ui.components.HomeNavigationDrawer
import com.example.departmentalresourcemanagement.features.home.ui.components.HomeTopBar
import com.example.departmentalresourcemanagement.features.home.ui.navigation.HomeDestinations
import com.example.departmentalresourcemanagement.features.home.ui.navigation.toDestination
import com.example.departmentalresourcemanagement.features.home.viewmodel.HomeNavigationItems
import kotlinx.coroutines.launch


@Composable
fun HomeContent(
    username: String,
    userBitmap: Bitmap?,
    onNavigate: (HomeDestinations) -> Unit,
    openNotifications: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var showLogoutDialog by rememberSaveable { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    HomeNavigationDrawer(
        username = username,
        drawerState = drawerState,
        userBitmap = userBitmap,
        modifier = modifier,
        navigateItem = {
            coroutineScope.launch { drawerState.close() }
            when (it) {
                HomeNavigationItems.LOGOUT -> showLogoutDialog = true
                else -> onNavigate(it.toDestination())
            }
        },
        content = {
            Scaffold(
                topBar = {
                    HomeTopBar(
                        openNavigationDrawer = {
                            coroutineScope.launch { drawerState.open() }
                        },
                        openNotifications = openNotifications,
                    )
                },
            ) { padding ->
                Re(Modifier.padding(padding))
            }
        },
    )

//    if (showLogoutDialog) {
//        MifosAlertDialog(
//            onDismissRequest = { showLogoutDialog = false },
//            dismissText = stringResource(id = R.string.cancel),
//            onConfirmation = {
//                onNavigate(HomeDestinations.LOGOUT)
//                showLogoutDialog = false
//            },
//            confirmationText = stringResource(id = R.string.logout),
//            dialogTitle = stringResource(id = R.string.dialog_logout),
//            dialogText = "",
//        )
//    }
}



@Composable
internal fun Re(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState),
    ) {


        Spacer(modifier = Modifier.height(8.dp))

        Text("Hello")

        Spacer(modifier = Modifier.height(8.dp))

    }
}
