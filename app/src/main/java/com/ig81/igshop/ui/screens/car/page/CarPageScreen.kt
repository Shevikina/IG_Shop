package com.ig81.igshop.ui.screens.car.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ig81.igshop.ui.screens.car.page.models.CarPageAction
import com.ig81.igshop.ui.screens.car.page.models.CarPageEvent
import com.ig81.igshop.ui.screens.car.page.views.CarPageViewDisplay
import com.ig81.igshop.ui.theme.components.JetDialog

@Composable
fun CarPageScreen(carId: Int, navController: NavController) {
    val viewAction = remember { mutableStateOf<CarPageAction?>(null) }
    when (val action = viewAction.value) {
        is CarPageAction.ShowDialog -> {
            Dialog(onDismissRequest = { viewAction.value = null }) {
                JetDialog(
                    title = action.title,
                    body = action.body,
                    buttonText = action.buttonText,
                    onClose = { viewAction.value = null }
                )
            }
        }

        else -> {}
    }

    CarPageViewDisplay(carId) { event ->
        when (event) {
            is CarPageEvent.CloseScreen -> {
                navController.popBackStack()
            }

            is CarPageEvent.BookCar -> {
                viewAction.value = CarPageAction.ShowDialog(
                    title = "Ошибка",
                    body = "Проверьте подключение к сети Интернет",
                    buttonText = "ОК"
                )
            }

            else -> {}
        }
    }
}

@Preview
@Composable
private fun CarPageScreenPreview() {
    CarPageScreen(0, rememberNavController())
}