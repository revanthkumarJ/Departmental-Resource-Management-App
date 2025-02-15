package com.example.departmentalresourcemanagement.features.officials.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar

@Composable
fun OfficialsScreen(navigateBack:()->Unit) {
    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("Officials") }
            )
        },
        content = { padding->
            Text("Official Screen", color = Color.White, modifier = Modifier.padding(padding))
        }
    )
}