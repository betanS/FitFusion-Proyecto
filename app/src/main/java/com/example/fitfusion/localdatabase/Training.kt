package com.example.fitfusion.localdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Training(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val dia: Int,
    val fecha: String,
    val entrenamiento: String
)
