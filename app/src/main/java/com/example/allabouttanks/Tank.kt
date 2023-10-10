package com.example.allabouttanks

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tank(
    var name: String,
    var description: String,
    var photo: String,
    var main_armament: String,
    var secondary_armament: String,
    var weight: String,
    var maximum_speed: String,
    var armour: String,
    var history: String,
    val link: String
) : Parcelable