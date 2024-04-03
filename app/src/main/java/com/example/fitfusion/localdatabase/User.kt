package com.example.fitfusion.localdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val username: String,
    val email: String,
    val password: String
)
@Entity
data class training(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val dia: Int,
    val fecha: String,
    val entrenamiento: String
)
