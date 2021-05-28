package com.android.example.housingconnect

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
        val id: Int,
        // TODO PHASE 2.2 - Define all the columns that are define in the database on the server
        //      make sure to write the names of the variables exactly like they are written on
        //      the server
        val email: String,
        val type: String,
        val bed: Int,
        val bath: Int,
        val price: Int,
        val covidTested: String,
        val moveIn: String,
        val location: String,
        val desc: String,
        val date: String,
        val image: String
) : Parcelable
