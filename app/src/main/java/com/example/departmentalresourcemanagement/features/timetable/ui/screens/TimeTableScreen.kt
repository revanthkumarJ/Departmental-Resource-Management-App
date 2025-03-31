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
import com.example.departmentalresourcemanagement.api.fetchTimeTableData
import com.example.departmentalresourcemanagement.core.ui.RevanthLoader
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.timetable.model.TimetablecardContent
import com.example.departmentalresourcemanagement.features.timetable.ui.components.IndividualDayTimeTable
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@Composable
fun TimeTableScreen(navigateBack: () -> Unit) {
    val timeTableData = remember { mutableStateOf<Map<String, List<TimetablecardContent>>>(emptyMap()) }
    val isLoading = remember { mutableStateOf(true) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            fetchTimeTableData { data ->
                timeTableData.value = data
                isLoading.value = false
            }
        }

    }

    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("Time Table") }
            )
        },
        content = { padding ->
            if (isLoading.value) {
                RevanthLoader()
            } else {
                TabRowWithPager(timeTableData.value, Modifier.padding(padding))
            }
        }
    )
}



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
