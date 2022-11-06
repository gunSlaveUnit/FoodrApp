package com.github.gunslaveunit.foodrapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Table(
    val number: Int,
    val description: String,
    val capacity: Int
): Parcelable