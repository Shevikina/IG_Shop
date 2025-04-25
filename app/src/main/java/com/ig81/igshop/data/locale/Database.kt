package com.ig81.igshop.data.locale

import com.ig81.igshop.ui.screens.home.models.SportsCarInfo
import com.ig81.igshop.ui.screens.home.models.UserRatingInfo

object Database {
    val sportsCarList = listOf(
        SportsCarInfo(
            id = 0,
            carName = "Lamba-A",
            carType = "Классический спорткар",
            imagePath = "file:///android_asset/App5_Image1.jpg",
            rating = 4,
            price = 177000,
            speedRating = 4,
            caseRating = 5,
            shieldsRating = 3,
            description = "Лучший спорткар на всём Внешнем кольце. Его модернезированные версии завоевывают первые места на всех крупных соревнованиях в галактике!"
        ),
        SportsCarInfo(
            id = 1,
            carName = "Lamba Sport",
            carType = "Премиум",
            imagePath = "file:///android_asset/App5_Image2.jpg",
            rating = 5,
            price = 500000,
            speedRating = 5,
            caseRating = 5,
            shieldsRating = 4
        )
    )
    val achievementsList = listOf(
        UserRatingInfo(
            number = 1,
            name = "Джонни Джонсон",
            balls = 123,
            isVip = true
        ),
        UserRatingInfo(
            number = 2,
            name = "Мэри Мэроу",
            balls = 102
        ),
        UserRatingInfo(
            number = 3,
            name = "Дики Дуо",
            balls = 71,
            isVip = true
        ),
        UserRatingInfo(
            number = 4,
            name = "Рикки Ру",
            balls = 57
        ),
        UserRatingInfo(
            number = 5,
            name = "Тин Тин",
            balls = 55,
            isVip = true
        )
    )
}