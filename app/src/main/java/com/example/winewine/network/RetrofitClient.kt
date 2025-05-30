package com.example.winewine.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.winewine.network.ApiService

object RetrofitClient {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    }