package com.ig81.igshop.ui.screens.achievements

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ig81.igshop.ui.screens.achievements.models.AchievementsEvent
import com.ig81.igshop.ui.screens.achievements.views.AchievementsViewDisplay

@Composable
fun AchievementsScreen(navController: NavController) {
    AchievementsViewDisplay { event ->
        when (event) {
            is AchievementsEvent.CloseScreen -> {
                navController.popBackStack()
            }

            is AchievementsEvent.ViewFullList -> {}

            else -> {}
        }

    }
}