package com.example.departmentalresourcemanagement.features.hod.model

import com.google.firebase.Timestamp


data class HodMessage(
    val name: String = "",
    val title:String="",
    val message: String = "",
    val timestamp: Timestamp? = null
)