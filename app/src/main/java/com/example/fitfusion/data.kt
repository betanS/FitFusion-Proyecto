package com.example.fitfusion

import java.util.Date

data class Workout(
    val name: String,
    val exercises: List<Exercise>,
    val date: Date
)
data class Exercise(
    val name: String,
    val sets: Int,
    val reps: Int
)