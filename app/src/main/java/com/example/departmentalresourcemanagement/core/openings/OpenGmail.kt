package com.example.departmentalresourcemanagement.core.openings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun openGmail(context: Context, email: String) {
    try {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "No email app found!", Toast.LENGTH_SHORT).show()
    }
}
