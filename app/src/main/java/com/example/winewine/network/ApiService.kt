package com.example.winewine.network

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface ApiService {
    @POST("api/auth/login")
    suspend fun login(@Body dados: Map<String, String>): Response<LoginResponse>
}
