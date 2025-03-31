package com.example.departmentalresourcemanagement.features.hod.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.departmentalresourcemanagement.api.fetchHodMessages
import com.example.departmentalresourcemanagement.core.ui.RevanthLoader
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.hod.model.HodMessage
import com.example.departmentalresourcemanagement.features.hod.ui.components.MsgCard
import kotlinx.coroutines.launch

@Composable
fun HodScreen(navigateBack:()->Unit) {
    val coroutineScope = rememberCoroutineScope()
    var hodMessages by remember { mutableStateOf<List<HodMessage>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            hodMessages = fetchHodMessages()
            isLoading = false
        }
    }

    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("HOD Msg's") }
            )
        },
        content = { padding->
            if (isLoading) {
                RevanthLoader()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(padding)
                ) {
                    items(hodMessages.size) { index ->
                        MsgCard(hodMessages[index].name, hodMessages[index].message,hodMessages[index].timestamp,hodMessages[index].title)
                    }
                }
            }
        }
    )
}