package com.ig81.igshop.data.locale

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
            corpusRating = 5,
            shieldRating = 3,
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
            corpusRating = 5,
            shieldRating = 4
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

    val specialOfferList = listOf(
        SpecialOfferInfo(
            number = "№ 364 154",
            selected = false,
            backgroundAlpha = 0.03f
        ),
        SpecialOfferInfo(
            number = "№ 121 453",
            selected = false,
            width = 0.87f
        ),
        SpecialOfferInfo(
            number = "№ 105 423",
            selected = false,
            backgroundAlpha = 0.1f,
            width = 0.74f
        ),
        SpecialOfferInfo(
            number = "№ 103 436",
            selected = true,
            backgroundAlpha = 0.23f,
            width = 0.6f
        )
    )
}