package com.example.kotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class User(
    val username: String

):Parcelable
