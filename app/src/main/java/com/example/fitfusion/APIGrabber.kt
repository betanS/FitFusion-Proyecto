package com.example.fitfusion



import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.FileOutputStream
import java.net.URL

suspend fun saveUrlContentAsText(url: String, filename: String) {
    withContext(Dispatchers.IO) {
        val inputStream = BufferedInputStream(URL(url).openStream())
        val outputStream = FileOutputStream(filename)
        val buffer = ByteArray(1024)
        var bytesRead: Int
        while (inputStream.read(buffer).also { bytesRead = it } != -1) {
            outputStream.write(buffer, 0, bytesRead)
        }
        inputStream.close()
        outputStream.close()
    }
}

suspend fun main() {
    val url = "https://api.openweathermap.org/data/2.5/weather?lat=29.14&lon=-13.49&appid=60cb6d67cc3926c8f6f84953c2190ff4"
    val filename = "content.txt"
    saveUrlContentAsText(url, filename)
    println("Contenido de la URL guardado en el archivo: $filename")
}
