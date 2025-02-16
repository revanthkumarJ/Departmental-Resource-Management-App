package com.example.departmentalresourcemanagement.features.crprofiles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.departmentalresourcemanagement.R
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.crprofiles.model.CrProfile
import com.example.departmentalresourcemanagement.features.officials.model.Official
import com.example.departmentalresourcemanagement.features.officials.ui.components.OfficialCard

@Composable
fun CrProfileScreen(navigateBack:()->Unit) {
    val e4crs = listOf(
        CrProfile(
            image= R.drawable.placeholder,
            name = "J.Revanth Kumar",
            section = "E4 Section A"
        ),
        CrProfile(
            image= R.drawable.placeholder,
            name = "J.Revanth Kumar",
            section = "E4 Section B"
        ),
        CrProfile(
            image= R.drawable.placeholder,
            name = "J.Revanth Kumar",
            section = "E4 Section C"
        ),
        CrProfile(
            image= R.drawable.placeholder,
            name = "J.Revanth Kumar",
            section = "E4 Section D"
        )
    )

    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("CR's Profiles") }
            )
        },
        content = { padding->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                item {
                    Text(text = "E4 Cr's", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
                item {
                    IndividualBatchCR(e4crs)
                }
                item {
                    Text(text = "E3 Cr's", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
                item {
                    IndividualBatchCR(e4crs)
                }
                item {
                    Text(text = "E2 Cr's", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
                item {
                    IndividualBatchCR(e4crs)
                }
                item {
                    Text(text = "E1 Cr's", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                }
                item {
                    IndividualBatchCR(e4crs)
                }

            }
        }
    )
}