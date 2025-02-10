package com.example.departmentalresourcemanagement.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import kotlin.math.min

@Composable
fun RevanthTextUserImage(
    text: String,
    modifier: Modifier = Modifier,
) {
    var boxSize by remember { mutableStateOf(Size.Zero) }
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = MaterialTheme.colorScheme.primary)
            .onGloballyPositioned { coordinates ->
                boxSize = Size(
                    coordinates.size.width.toFloat(),
                    coordinates.size.height.toFloat(),
                )
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = with(LocalDensity.current) {
                (min(boxSize.width, boxSize.height) / 2).toSp()
            },
        )
    }
}
