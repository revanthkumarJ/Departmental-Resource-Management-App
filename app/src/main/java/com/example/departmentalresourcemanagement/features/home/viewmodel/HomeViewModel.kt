package com.example.departmentalresourcemanagement.features.home.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.departmentalresourcemanagement.R

class HomeViewModel {
}


enum class HomeNavigationItems(
    val nameResId: Int,
    val imageVector: ImageVector,
) {
    Home(
        nameResId = R.string.home,
        imageVector = Icons.Default.Home,
    ),

}
