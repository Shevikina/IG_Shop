package com.ig81.igshop.ui.screens.achievements.models

sealed class AchievementsViewSubState {
    data object Buyers : AchievementsViewSubState()
    data object VipBuyers : AchievementsViewSubState()
}