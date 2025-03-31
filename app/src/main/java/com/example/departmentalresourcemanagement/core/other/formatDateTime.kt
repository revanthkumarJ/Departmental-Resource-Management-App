package com.example.departmentalresourcemanagement.core.other

import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

fun formatDateAndDay(timestamp: Timestamp?): Map<String, String> {
    return timestamp?.toDate()?.let { date ->
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())

        mapOf(
            "date" to dateFormat.format(date),
            "day" to dayFormat.format(date)
        )
    } ?: mapOf("date" to "Unknown", "day" to "Unknown")
}