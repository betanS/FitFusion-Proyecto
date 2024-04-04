package com.example.fitfusion.localdatabase.usuarios

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user WHERE username = :username")
    suspend fun getUserByUsername(username: String): List<User>

    @Query("SELECT * FROM user WHERE email = :email")
    suspend fun getUserByEmail(email: String): List<User>

    // Nuevas funciones para comprobar si el usuario o el correo electrónico ya existen
    @Query("SELECT * FROM user WHERE username = :username OR email = :email")
    suspend fun getUserByUsernameOrEmail(username: String, email: String): List<User>

}

