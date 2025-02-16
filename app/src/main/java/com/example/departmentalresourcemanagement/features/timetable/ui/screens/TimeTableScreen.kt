package com.example.departmentalresourcemanagement.features.timetable.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.timetable.model.TimetablecardContent
import com.example.departmentalresourcemanagement.features.timetable.ui.components.IndividualDayTimeTable
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@Composable
fun TimeTableScreen(navigateBack: () -> Unit) {
    val timeTableData = mapOf(
        "Monday" to List(7) { TimetablecardContent(sub = "DBMS", faculty = "RatnaKumari") },
        "Tuesday" to List(7) { TimetablecardContent(sub = "OS", faculty = "Vamsi Krishna") },
        "Wednesday" to List(7) { TimetablecardContent(sub = "CN", faculty = "Harika") },
        "Thursday" to List(7) { TimetablecardContent(sub = "DAA", faculty = "Ravi Teja") },
        "Friday" to List(7) { TimetablecardContent(sub = "AI", faculty = "Suresh") },
        "Saturday" to List(7) { TimetablecardContent(sub = "ML", faculty = "Praveen") }
    )

    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("Time Table") }
            )
        },
        content = { padding ->
            TabRowWithPager(timeTableData, Modifier.padding(padding))
        }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabRowWithPager(timeTableData: Map<String, List<TimetablecardContent>>, modifier: Modifier) {
    val days = timeTableData.keys.toList()
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

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
            days.forEachIndexed { index, day ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch { pagerState.animateScrollToPage(index) }
                    },
                    modifier = Modifier.padding(8.dp),
                    content = {
                        Text(
                            text = day,
                            modifier = Modifier.padding(8.dp),
                            color =if (pagerState.currentPage == index) Color.Green else MaterialTheme.colorScheme.primary,
                            fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                )
            }
        }

        HorizontalPager(
            count = days.size,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            IndividualDayTimeTable(
                modifier = Modifier.padding(16.dp),
                time = timeTableData[days[page]] ?: emptyList()
            )
        }
    }
}

