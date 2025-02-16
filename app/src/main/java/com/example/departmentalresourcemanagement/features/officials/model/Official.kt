package com.example.departmentalresourcemanagement.features.officials.model

data class Official(
    val image:Int,
    val name: String,
    val specialPosition: String?,
    val designation: String,
    val skills: List<String>
)