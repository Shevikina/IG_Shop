package com.ig81.igshop.ui.screens.search.models

sealed class SearchEvent {

    data class ChangeQuery(val newValue: String) : SearchEvent()
    data object ReloadScreen : SearchEvent()
    data object CloseScreen : SearchEvent()
    data class OpenSportsCarPageScreen(val cardId: Int) : SearchEvent()
}