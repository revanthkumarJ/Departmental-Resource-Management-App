package com.example.departmentalresourcemanagement.features.officials.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.departmentalresourcemanagement.R
import com.example.departmentalresourcemanagement.core.ui.RevanthScaffold
import com.example.departmentalresourcemanagement.core.ui.RevanthTopBar
import com.example.departmentalresourcemanagement.features.officials.model.Official
import com.example.departmentalresourcemanagement.features.officials.ui.components.OfficialCard

@Composable
fun OfficialsScreen(navigateBack: () -> Unit) {
    val officials = listOf(
        Official(
            image=R.drawable.satya_sir,
            name = "Satyanandaram N",
            specialPosition = null,
            designation = "Lecturer",
            skills = listOf("JAVA", "OOPS", "Android", "JDBC","SDLC","JSP","XML")
        ),
        Official(
            image=R.drawable.ravi_sir,
            name = "Dr. Ravi Kumar",
            specialPosition = "Administrative Officer",
            designation = "Assistant Professor",
            skills = listOf("Java", "Compiler Design", "Microservices")
        ),
        Official(
            image = R.drawable.vinod_sir,
            name = "K. Vinod",
            specialPosition = "Placement Coordinator",
            designation = "Assistant Professor",
            skills = listOf("Networking", "Cybersecurity", "Linux")
        ),
        Official(
            image = R.drawable.placeholder,
            name = "dummy",
            specialPosition = null,
            designation = "Lecturer",
            skills = listOf("Networking", "Cybersecurity", "Linux")
        ),
        Official(
            image = R.drawable.placeholder,
            name = "dummy",
            specialPosition = null,
            designation = "Lecturer",
            skills = listOf("Networking", "Cybersecurity", "Linux")
        )
    )

    RevanthScaffold(
        topBar = {
            RevanthTopBar(
                navigateBack = navigateBack,
                title = { Text("Officials") }
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    OfficialCard(
                        image = R.drawable.ratna_mam,
                        officialName = "Dr. RatnaKumari Challa",
                        officialSpecialPosition = "Head of Department",
                        officialDesignation = "Associate Professor",
                        officialSkills = listOf("DBMS", "COA", "SQL", "AI"),
                        isHod = true
                    )
                }

                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        items(officials) { official ->
                            OfficialCard(
                                image = official.image,
                                officialName = official.name,
                                officialSpecialPosition = official.specialPosition,
                                officialDesignation = official.designation,
                                officialSkills = official.skills
                            )
                        }
                    }
                }
            }
        }
    )
}

