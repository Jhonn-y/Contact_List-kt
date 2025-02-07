package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class Contacts(
    val name: String,
    val number: String,
    @DrawableRes val avatar: Int
)
