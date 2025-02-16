package com.example.departmentalresourcemanagement.core.openings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun openWhatsApp(context: Context, phoneNumber: String) {
    try {
        val uri = Uri.parse("https://wa.me/$phoneNumber")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "WhatsApp is not installed!", Toast.LENGTH_SHORT).show()
    }
}
