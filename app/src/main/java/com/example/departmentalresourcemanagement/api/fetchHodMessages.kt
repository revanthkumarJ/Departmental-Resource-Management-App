package com.example.departmentalresourcemanagement.api

import android.util.Log
import com.example.departmentalresourcemanagement.features.hod.model.HodMessage
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

suspend fun fetchHodMessages(): List<HodMessage> {
    return fetchGeneralMessages("hod_messages")
}

suspend fun fetchFacultyMessages(): List<HodMessage> {
    return fetchGeneralMessages("faculty_messages")
}

suspend fun fetchCrMessages(): List<HodMessage> {
    return fetchGeneralMessages("cr_messages")
}

suspend fun fetchGeneralMessages(collection:String): List<HodMessage> {
    return try {
        val db = FirebaseFirestore.getInstance()
        val snapshot = db.collection(collection)
            .orderBy("timestamp")
            .get()
            .await()
        Log.e("FireStore",snapshot.toString())
        snapshot.documents.mapNotNull { it.toObject(HodMessage::class.java) }
    } catch (e: Exception) {
        Log.e("Firestore", "Error fetching HOD messages", e)
        emptyList()
    }
}