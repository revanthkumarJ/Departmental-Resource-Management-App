package com.example.departmentalresourcemanagement.core.openings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun openDialPad(context: Context, phoneNumber: String) {
    try {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "No dialer app found!", Toast.LENGTH_SHORT).show()
    }
}
