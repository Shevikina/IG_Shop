package com.ig81.igshop.ui.screens.search

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ig81.igshop.ui.navigation.NavScreen
import com.ig81.igshop.ui.screens.search.models.SearchEvent
import com.ig81.igshop.ui.screens.search.views.SearchViewDisplay

@Composable
fun SearchScreen(navController: NavController) {
    SearchViewDisplay { event ->
        when (event) {
            is SearchEvent.CloseScreen -> {
                navController.popBackStack()
            }

            is SearchEvent.OpenSportsCarPageScreen -> {
                navController.navigate(NavScreen.CarPage(event.cardId))
            }

            else -> {}
        }

    }
}

