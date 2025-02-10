package com.example.departmentalresourcemanagement.features.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeTopBar(
    openNavigationDrawer: () -> Unit,
    openNotifications: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = "Home")
        },
        actions = {
            IconButton(
                onClick = {
                    openNotifications()
                },
            ) {
                Box(
                    modifier = Modifier,
                    contentAlignment = Alignment.TopEnd,
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    openNavigationDrawer()
                },
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                )
            }
        },
        modifier = modifier,
    )
}

@Preview
@Composable
private fun HomeTopBarPreview() {
    HomeTopBar(
        openNavigationDrawer = {},
        openNotifications = {},

    )
}
