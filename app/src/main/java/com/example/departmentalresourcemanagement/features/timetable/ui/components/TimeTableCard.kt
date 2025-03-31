package com.example.departmentalresourcemanagement.features.timetable.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

var timings= listOf(
    "8:30 AM - 9:30 AM",
    "9:30 AM - 10:30 AM",
    "10:40 AM - 11:40 AM",
    "11:40 AM - 12:40 PM",
    "1:30 PM - 2:30 PM",
    "2:30 PM - 3:30 PM",
    "3:40 PM - 4:40 PM"
)

@Composable
fun TimeTableCard(ind:Int,sub:String,faculty:String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column (

            ){
                Text("Period ${ind+1}")
                Text(timings[ind])
            }
            if(sub!="Unknown")
            {
                Column (

                ){
                    Text(sub)
                    Text(faculty)
                }
            }
            else{
                Text("Free Period")
            }

        }
    }
}