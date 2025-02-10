package com.example.departmentalresourcemanagement.core.ui

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale

@Composable
fun RevanthUserImage(
    bitmap: Bitmap?,
    modifier: Modifier = Modifier,
    username: String? = null,
) {
    if (bitmap == null) {
        RevanthTextUserImage(
            text = username?.firstOrNull()?.toString() ?: "R",
            modifier = modifier,
        )
    } else {
        Image(
            modifier = modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
        )
    }
}