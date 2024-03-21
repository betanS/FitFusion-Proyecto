package com.example.fitfusion.data.network

import com.example.fitfusion.data.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainService {
    val retrofit = RetrofitHelper.getRetrofit()
    val apiKey = "60cb6d67cc3926c8f6f84953c2190ff4"

    suspend fun getCurrentWeather(city: String): WeatherResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(MainClient::class.java).getCurrentWeather(city, apiKey)
            return@withContext response.body()!!
        }
    }

}