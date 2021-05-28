package com.android.example.housingconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class MainActivity : AppCompatActivity() {

    // TODO: PHASE 2.4 - late-Initialize HousingService variable
    lateinit var housingService: HousingService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: PHASE 2.4 - Create instance of a retrofit service (HousingService) and connect
        //  it as a member variable of the MainActivity to reference is in Fragments
        //  (in other words, initialize the HousingService variable above that was defined
        //  as being late-initialized)
        housingService = Retrofit.Builder()
            .baseUrl("https://Project-3-RentWell-Server.ruiyihe.repl.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create()
    }
}
