package com.example.departmentalresourcemanagement.features.faculty.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.hod.ui.components.MsgCard

@Composable
fun FacultyScreen (navigateBack:()->Unit){
    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("Faculty msg's") }
            )
        },
        content = { padding->
            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(padding)
            ) {
                item {
                    MsgCard("Satyanandaram")
                }
                item {
                    MsgCard("RatnaKumari Challa")
                }
                item {
                    MsgCard("Ravi")
                }
                item {
                    MsgCard("Vinod")
                }
            }
        }
    )
}