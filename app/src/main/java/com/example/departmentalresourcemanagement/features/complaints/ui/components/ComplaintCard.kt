package com.example.departmentalresourcemanagement.features.complaints.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.departmentalresourcemanagement.features.complaints.model.Complaint

@Composable
fun ComplaintCard(
    complaint: Complaint
) {
    Card(
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = complaint.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Complaint on: ${complaint.dateRaised}", style = MaterialTheme.typography.bodyMedium)
            Text(text = complaint.description, style = MaterialTheme.typography.bodySmall)
            Text(text = "Raised on: ${complaint.category}", style = MaterialTheme.typography.bodySmall)

            complaint.resolvedDate?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Resolved on: $it", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
            }

            complaint.resolvedDescription?.let {
                Text(text = it, style = MaterialTheme.typography.bodySmall)
            }

            complaint.declinedDate?.let{
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Declined on: $it", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
            }
            complaint.declinedDescription?.let {
                Text(text = it, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

