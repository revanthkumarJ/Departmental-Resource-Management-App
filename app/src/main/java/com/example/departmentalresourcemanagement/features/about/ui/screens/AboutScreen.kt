package com.example.departmentalresourcemanagement.features.about.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.R
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.officials.ui.components.OfficialCard

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
            AboutContent(Modifier.padding(padding))
        }
    )
}


@Composable
fun AboutContent(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(50.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher),
                contentDescription = null,
                modifier = Modifier.size(50.dp).clip(CircleShape)
            )
            Spacer(Modifier.width(16.dp))
            Text("DRM", style = MaterialTheme.typography.titleLarge)
        }

        Text(
            "Department Resource Management App is a native Android app developed to manage Department resources efficiently, such as information, official details, timetables, etc.",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Technologies Used Section
        Text(
            "Technologies Used:",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            "• FrontEnd: Kotlin Jetpack Compose\n" +
                    "• Dependency Injection: Koin\n" +
                    "• Database: Firebase\n" +
                    "• Notifications: Firebase Notifications\n" +
                    "• Architecture: MVVM",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Developed By:",style = MaterialTheme.typography.titleMedium)

        OfficialCard(
            image = R.drawable.placeholder,
            officialName = "J. Revanth Kumar",
            officialSpecialPosition = null,
            officialDesignation = "App Developer",
            officialSkills = listOf("Kotlin", "Java", "JS", "React", "Express", "DSA", "Git", "KMP", "CMP"),
            isHod = true
        )
    }
}

