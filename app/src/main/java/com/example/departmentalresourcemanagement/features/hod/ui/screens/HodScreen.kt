package com.example.departmentalresourcemanagement.features.hod.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar

@Composable
fun HodScreen(navigateBack:()->Unit) {
    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("HOD Msg's") }
            )
        },
        content = { padding->
            Text("Hod msg's Screen", color = Color.White, modifier = Modifier.padding(padding))
        }
    )
}