package com.example.departmentalresourcemanagement.api

import android.util.Log
import com.example.departmentalresourcemanagement.features.timetable.model.TimetablecardContent
import com.google.firebase.firestore.FirebaseFirestore

suspend fun fetchTimeTableData(onDataFetched: (Map<String, List<TimetablecardContent>>) -> Unit) {
    val db = FirebaseFirestore.getInstance()
    val timetableCollection = db.collection("timetable")

    timetableCollection.get()
        .addOnSuccessListener { documents ->
            val timeTableMap = mutableMapOf<String, List<TimetablecardContent>>()

            for (document in documents) {
                val day = document.id
                val slots = document.get("slots") as? List<Map<String, String>> ?: emptyList()

                val subjects = slots.map {
                    TimetablecardContent(
                        sub = it["sub"] ?: "Unknown",
                        faculty = it["faculty"] ?: "Unknown"
                    )
                }
                timeTableMap[day] = subjects
            }

            onDataFetched(timeTableMap)
        }
        .addOnFailureListener { e ->
            Log.e("Firestore", "Error fetching timetable", e)
        }
}
