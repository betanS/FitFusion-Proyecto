package com.example.fitfusion.data.network

import com.example.fitfusion.data.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainClient {
    @GET("/data/2.5/weather?units=metric")
    suspend fun getCurrentWeather(
        @Query("q") q: String,
        @Query("appid") appid: String
    ): Response<WeatherResponse>
}