package com.example.m5_l7.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://rickandmortyapi.com/api/")
        .build()

    val api = retrofit.create(ApiService::class.java)

}