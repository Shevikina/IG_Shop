package com.ig81.igshop.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ig81.igshop.ui.screens.achievements.AchievementsScreen
import com.ig81.igshop.ui.screens.car.page.CarPageScreen
import com.ig81.igshop.ui.screens.home.HomeScreen
import com.ig81.igshop.ui.screens.search.SearchScreen

@Composable
fun NavHostScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavScreen.Home,
        modifier = modifier.fillMaxSize()
    ) {
        composable<NavScreen.Home> { HomeScreen(navController) }
        composable<NavScreen.Achievements> { AchievementsScreen(navController) }
        composable<NavScreen.Search> { SearchScreen(navController) }
        composable<NavScreen.CarPage> { entry ->
            val page = entry.toRoute<NavScreen.CarPage>()
            CarPageScreen(page.carId, navController)
        }
    }
}