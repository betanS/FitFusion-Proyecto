package com.example.fitfusion

//class Data(val txtTitulo: String, val txtFP: String, val txtDescripcion: String, val imageurl: Painter)
data class Ejercicio(
    val day: Int,
    val name: String,
    val sets: Int,
    val reps: Int
)
data class Cardio(
    val day: Int,
    val name: String,
    val durationMins: Int
)