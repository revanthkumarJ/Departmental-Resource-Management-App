package com.example.departmentalresourcemanagement.core.openings

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast

fun openUrlInBrowser(context: Context, url: String) {
    try {
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "No browser found to open the link!", Toast.LENGTH_SHORT).show()
    }
}
