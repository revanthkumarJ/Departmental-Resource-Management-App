package com.example.departmentalresourcemanagement.features.timetable.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.departmentalresourcemanagement.features.timetable.model.TimetablecardContent

@Composable
fun IndividualDayTimeTable(modifier: Modifier,time:List<TimetablecardContent>) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        time.forEachIndexed { index, timetableItem ->
            TimeTableCard(
                ind = index,
                sub = timetableItem.sub,
                faculty = timetableItem.faculty
            )
        }
    }
}