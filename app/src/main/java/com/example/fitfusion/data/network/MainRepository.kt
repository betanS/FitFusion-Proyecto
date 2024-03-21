package com.example.fitfusion.data.network

import com.example.fitfusion.data.WeatherResponse

class MainRepository {
    val api = MainService()

    suspend fun getCurrentWeather(city: String): WeatherResponse {
        return api.getCurrentWeather(city)
    }
}