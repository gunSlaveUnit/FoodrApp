package com.github.gunslaveunit.foodrapp.utils.database

import android.graphics.BitmapFactory
import com.github.gunslaveunit.foodrapp.data.models.Table
import com.github.gunslaveunit.foodrapp.data.viewmodels.TableViewModel
import java.net.URL

class Initializer {
    fun prepopulateTables(tableViewModel: TableViewModel) {
        val table1 = Table(
            0, 1, "On the street", 2,
            BitmapFactory
                .decodeStream(
                    URL("https://i.pinimg.com/originals/1f/e1/80/1fe180aadeab797bab635bd0df79fffa.jpg")
                        .openStream()
                )
        )

        val table2 = Table(
            0, 2, "With friends", 4,
            BitmapFactory
                .decodeStream(
                    URL("https://www.retail.ru/upload/medialibrary/767/restaurant_449952_1280.jpg")
                        .openStream()
                )
        )

        val table3 = Table(
            0, 3, "For a celebration with a large group", 8,
            BitmapFactory
                .decodeStream(
                    URL("https://www.retail.ru/upload/medialibrary/c9c/bronirovanie_stolika_1_min.jpg")
                        .openStream()
                )
        )

        tableViewModel.add(table1)
        tableViewModel.add(table2)
        tableViewModel.add(table3)
    }
}