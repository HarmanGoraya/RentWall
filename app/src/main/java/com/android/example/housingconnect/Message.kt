package com.android.example.housingconnect

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// TODO: PHASE 2.2 - Define Message Data Class
//  Stores a variable of type String called message

data class Message(
    val message: String
)