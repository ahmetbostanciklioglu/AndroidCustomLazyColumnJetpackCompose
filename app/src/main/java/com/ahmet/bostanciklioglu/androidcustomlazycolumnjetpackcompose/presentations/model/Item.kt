package com.ahmet.bostanciklioglu.androidcustomlazycolumnjetpackcompose.presentations.model

import androidx.annotation.StringRes

data class Item(
    val image: Int,
    @StringRes val title: Int,
    @StringRes val content: Int
)
