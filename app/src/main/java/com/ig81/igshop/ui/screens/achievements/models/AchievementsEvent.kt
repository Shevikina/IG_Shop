package com.ig81.igshop.ui.screens.achievements.models

sealed class AchievementsEvent {
    data object EnterScreen : AchievementsEvent()
    data object ReloadScreen : AchievementsEvent()
    data class ChangeQuery(val newValue: String) : AchievementsEvent()
    data class ChangeTab(val num: Int) : AchievementsEvent()
}