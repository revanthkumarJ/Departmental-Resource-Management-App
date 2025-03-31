package com.example.departmentalresourcemanagement.features.cr.ui.screens

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
import com.example.departmentalresourcemanagement.api.fetchCrMessages
import com.example.departmentalresourcemanagement.core.ui.RevanthLoader
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.hod.model.HodMessage
import com.example.departmentalresourcemanagement.features.hod.ui.components.MsgCard
import kotlinx.coroutines.launch

@Composable
fun CrScreen(navigateBack:()->Unit) {
    val coroutineScope = rememberCoroutineScope()
    var hodMessages by remember { mutableStateOf<List<HodMessage>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            hodMessages = fetchCrMessages()
            isLoading = false
        }
    }

    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("CR Msg's") }
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
                        MsgCard(hodMessages[index].name, hodMessages[index].message,hodMessages[index].timestamp, title = hodMessages[index].title)
                    }
                }
            }
        }
    )
}