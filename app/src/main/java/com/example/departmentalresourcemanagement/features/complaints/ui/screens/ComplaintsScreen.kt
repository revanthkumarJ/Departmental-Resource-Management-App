package com.example.departmentalresourcemanagement.features.complaints.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.complaints.ui.components.ComplaintCard
import kotlinx.coroutines.launch
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import com.example.departmentalresourcemanagement.features.complaints.model.Complaint
import com.google.accompanist.pager.*

@Composable
fun ComplaintsScreen(navigateBack: () -> Unit) {
    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("Complaints") }
            )
        },
        content = { padding ->
            TabRowWithPagerForComplaints(modifier = Modifier.padding(padding))
        }
    )
}


@Composable
fun TabRowWithPagerForComplaints(modifier: Modifier) {
    val tabs = listOf("Pending", "Resolved","Declined")
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    val pendingComplaints = listOf(
        Complaint(title = "Syllabus Issue", category = "Syllabus", description = "Content is outdated", dateRaised = "2024-02-14"),
        Complaint(title = "Exam Schedule", category = "Exams", description = "Clashes with other subjects", dateRaised = "2024-02-12")
    )

    val resolvedComplaints = listOf(
        Complaint(title = "Library Timing", category = "Library", description = "Extend hours on weekends", dateRaised = "2024-02-01", resolvedDate = "2024-02-10", resolvedDescription = "Library now open till 9 PM"),
        Complaint(title = "Lab Equipment", category = "Lab", description = "Need updated hardware", dateRaised = "2024-01-20", resolvedDate = "2024-02-05", resolvedDescription = "New systems installed")
    )

    val declinedComplaints = listOf(
        Complaint(
            title = "Combined Canteen for Boys & Girls",
            category = "Canteen",
            description = "Requested a single canteen space for both boys and girls to improve accessibility.",
            dateRaised = "January 15, 2024",
            declinedDate = "January 25, 2024",
            declinedDescription = "Request declined due to existing policies, but separate seating areas have been introduced to improve convenience."
        ),
        Complaint(
            title = "More Wi-Fi Access Points",
            category = "Internet Facility",
            description = "Requested additional Wi-Fi routers in hostels for better connectivity.",
            dateRaised = "February 5, 2024",
            declinedDate = "February 12, 2024",
            declinedDescription = "Request declined due to budget constraints, but network optimization has been done to improve coverage."
        ),
        Complaint(
            title = "AC in Reading Hall",
            category = "Library",
            description = "Requested air conditioning in the reading hall for a better study environment.",
            dateRaised = "January 28, 2024",
            declinedDate = "February 8, 2024",
            declinedDescription = "Request denied due to high electricity costs, but additional ceiling fans have been installed."
        ),
        Complaint(
            title = "More Drinking Water Stations",
            category = "Facilities",
            description = "Requested additional water stations in academic blocks to reduce waiting time.",
            dateRaised = "February 10, 2024",
            declinedDate = "February 18, 2024",
            declinedDescription = "Request declined due to plumbing limitations, but existing stations have been repaired and upgraded."
        )
    )


    Column(modifier) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 16.dp,
            contentColor = Color.Gray,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.Green,
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
                )
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    },
                    modifier = Modifier.padding(8.dp),
                    content = {
                        Text(
                            text = tab,
                            modifier = Modifier.padding(8.dp),
                            color = if (pagerState.currentPage == index) Color.Green else MaterialTheme.colorScheme.primary,
                            fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        HorizontalPager(
            count = tabs.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            val complaints = if (page == 0) pendingComplaints else {if(page==1) resolvedComplaints else declinedComplaints}
            Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)) {
                complaints.forEach { complaint ->
                    ComplaintCard(complaint = complaint)
                }
            }
        }

    }
}
