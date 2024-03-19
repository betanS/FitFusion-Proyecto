package com.example.fitfusion


import androidx.compose.runtime.Composable
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Composable
fun getTemperature(city: String): String {
    val apiKey = "60cb6d67cc3926c8f6f84953c2190ff4"
    val urlString = "http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey"

    val url = URL(urlString)
    val connection = url.openConnection() as HttpURLConnection
    connection.requestMethod = "GET"

    val responseCode = connection.responseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
        val inputStream = connection.inputStream
        val reader = BufferedReader(InputStreamReader(inputStream))
        val response = StringBuffer()
        var inputLine: String?
        while (reader.readLine().also { inputLine = it } != null) {
            response.append(inputLine)
        }
        reader.close()

        val jsonResponse = response.toString()
        val temperature = parseTemperature(jsonResponse)
        val roundedTemperature = String.format("%.2f", temperature)
        return "$roundedTemperature°C $city"
    } else {
        return "Error fetching data"
    }
}
@Composable
fun parseTemperature(jsonResponse: String): Double {
    val jsonObject = jsonResponse.substring(1, jsonResponse.length - 1) // Remove outer curly braces
    val mainIndex = jsonObject.indexOf("\"main\":") + 8
    val tempIndex = jsonObject.indexOf("\"temp\":", mainIndex) + 7
    val commaIndex = jsonObject.indexOf(",", tempIndex)
    val tempString = jsonObject.substring(tempIndex, commaIndex)
    return tempString.toDouble() - 273.15 // Convert Kelvin to Celsius

}