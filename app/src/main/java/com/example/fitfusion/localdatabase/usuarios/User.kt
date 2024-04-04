package com.example.fitfusion.localdatabase.usuarios

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val email: String,
    val username: String,
    val password: String
)
