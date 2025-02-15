package com.example.departmentalresourcemanagement.features.home.ui.components

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.core.ui.RevanthUserImage
import com.example.departmentalresourcemanagement.features.home.viewmodel.HomeNavigationItems


@Composable
internal fun HomeNavigationDrawer(
    username: String,
    drawerState: DrawerState,
    userBitmap: Bitmap?,
    navigateItem: (HomeNavigationItems) -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        content = content,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                LazyColumn {
                    item {
                        RevanthUserImage(
                            modifier = Modifier
                                .padding(20.dp)
                                .size(84.dp),
                            bitmap = userBitmap,
                            username = username,
                        )
                        Text(
                            text = username,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .fillMaxWidth(),
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                    }

                    items(
                        items = HomeNavigationItems.entries.toList(),
                        key = { it.hashCode() },
                        contentType = { "NavigationItem" },
                    ) { item ->

                        NavigationDrawerItem(
                            modifier = Modifier.padding(horizontal = 20.dp),
                            label = {
                                Row {
                                    Icon(
                                        imageVector = item.imageVector,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = stringResource(id = item.nameResId))
                                }
                            },
                            selected = false,
                            onClick = { navigateItem(item) },
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        if (item == HomeNavigationItems.OFFICIALS) {
                            Column {
                                Spacer(modifier = Modifier.height(12.dp))
                                HorizontalDivider(
                                    modifier = Modifier.padding(horizontal = 20.dp),
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                            }
                        }
                    }
                }
            }
        },
    )
}

fun navigateItem(item: HomeNavigationItems) {
    // Function implementation will be added later
}
