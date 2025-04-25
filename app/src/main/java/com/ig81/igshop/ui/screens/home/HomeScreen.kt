package com.ig81.igshop.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ig81.igshop.ui.navigation.NavScreen
import com.ig81.igshop.ui.screens.home.models.HomeEvent
import com.ig81.igshop.ui.screens.home.views.HomeViewDisplay

@Composable
fun HomeScreen(navController: NavController) {
    HomeViewDisplay { event ->
        when (event) {
            is HomeEvent.OpenSearchScreen -> {
                navController.navigate(NavScreen.Search)
            }

            is HomeEvent.OpenSportsCarPageScreen -> {
                navController.navigate(NavScreen.CarPage(event.carId))
            }

            is HomeEvent.OpenAchievementsScreen -> {
                navController.navigate(NavScreen.Achievements)
            }

            else -> {}
        }
    }
}