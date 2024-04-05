package com.example.fitfusion.localdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Training(
    @PrimaryKey
    val id: Int,
    val localidad: String,
    val fecha: String,
    val entrenamiento: String
)
