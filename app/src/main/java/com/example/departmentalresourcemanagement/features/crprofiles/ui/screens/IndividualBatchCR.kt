package com.example.departmentalresourcemanagement.features.crprofiles.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.departmentalresourcemanagement.features.crprofiles.model.CrProfile
import com.example.departmentalresourcemanagement.features.crprofiles.ui.components.CrProfileCard

@Composable
fun IndividualBatchCR(crsProfiles:List<CrProfile>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        items(crsProfiles) { cr ->
            CrProfileCard(
                image = cr.image,
                name = cr.name,
                section = cr.section
            )
        }
    }
}