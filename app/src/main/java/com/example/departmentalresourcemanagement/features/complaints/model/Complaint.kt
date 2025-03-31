package com.example.departmentalresourcemanagement.features.complaints.model

data class Complaint(
    val title:String,
    val category:String,
    val description:String,
    val dateRaised:String,
    val resolvedDate:String?=null,
    val resolvedDescription:String?=null,
    val declinedDate:String?=null,
    val declinedDescription:String?=null,
)
