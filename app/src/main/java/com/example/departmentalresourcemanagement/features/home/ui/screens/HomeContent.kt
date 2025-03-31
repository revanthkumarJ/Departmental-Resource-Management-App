package com.example.departmentalresourcemanagement.features.home.ui.screens

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.R
import com.example.departmentalresourcemanagement.core.openings.openGmail
import com.example.departmentalresourcemanagement.core.openings.openUrlInBrowser
import com.example.departmentalresourcemanagement.core.ui.AutoScrollingCarousel
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
            onNavigate(it.toDestination())
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
                Home(Modifier.padding(padding))
            }
        },
    )
}


@Composable
internal fun Home(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AutoScrollingCarousel(
            listOf(
                painterResource(R.drawable.a),
                painterResource(R.drawable.b),
                painterResource(R.drawable.c),
                painterResource(R.drawable.d)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Department Of CSE",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Welcome to the Department Resource Management App. A one-stop solution where you can access: \n\n" +
                    "- Timetables\n" +
                    "- Announcements\n" +
                    "- Official details\n" +
                    "- Messages from HOD, Faculty, and CRs\n" +
                    "- Registration links\n" +
                    "- Notifications & updates\n" +
                    "- Faculty and CR details\n" +
                    "- Complaint registration system\n\n" +
                    "Stay updated with everything about the department!",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Social Media Icons
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.gmail),
                contentDescription = "Gmail",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { openGmail(context, "pccoordinator@rguktrkv.ac.in") }
            )

            Image(
                painter = painterResource(id = R.drawable.linkedin),
                contentDescription = "LinkedIn",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { openUrlInBrowser(context, "https://www.linkedin.com/company/102075873/admin/dashboard/") }
            )

            Image(
                painter = painterResource(id = R.drawable.github),
                contentDescription = "GitHub",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { openUrlInBrowser(context, "https://github.com/orgs/Student-Recreation-Center-CSE-RKV/repositories") }
            )
        }
    }
}
