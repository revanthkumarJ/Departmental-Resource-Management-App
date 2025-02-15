package com.example.departmentalresourcemanagement.features.about.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.departmentalresourcemanagement.R
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar

@Composable
fun AboutScreen(navigateBack: () -> Unit){
    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("About") }
            )
        },
        content = { padding->
            Text("About Screen", color = Color.White, modifier = Modifier.padding(padding))
        }
    )
}