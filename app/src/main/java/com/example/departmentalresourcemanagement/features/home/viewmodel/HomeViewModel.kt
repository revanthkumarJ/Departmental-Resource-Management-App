package com.example.departmentalresourcemanagement.features.home.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
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
    Timetable(
        nameResId = R.string.timeTable,
        imageVector = Icons.Default.Home,
    ),
    HOD(
        nameResId = R.string.message_from_hod,
        imageVector = Icons.Default.Star,
    ),
    FACULTY(
        nameResId = R.string.message_from_faculty,
        imageVector = Icons.Default.Person,
    ),
    CR(
        nameResId = R.string.message_from_cr,
        imageVector = Icons.Default.Person,
    ),
    OFFICIALS(
        nameResId = R.string.message_from_officials,
        imageVector = Icons.Default.Face,
    ),
    CR_PROFILES(
        nameResId = R.string.cr_profiles,
        imageVector = Icons.Default.Face,
    ),



    ABOUT_US(
        nameResId = R.string.aboutUs,
        imageVector = Icons.Default.Info,
    ),
    SETTINGS(
        nameResId = R.string.settings,
        imageVector = Icons.Default.Settings,
    ),
    APP_INFO(
        nameResId = R.string.app_info,
        imageVector = Icons.Default.Info,
    ),
    LOGOUT(
        nameResId = R.string.logout,
        imageVector = Icons.Default.ExitToApp,
    ),


}
