package com.example.fitfusion.localdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM users WHERE email = :email")
    suspend fun getUserByEmail(email: String): User?

    // Nuevas funciones para comprobar si el usuario o el correo electrónico ya existen
    @Query("SELECT * FROM users WHERE username = :username OR email = :email")
    suspend fun getUserByUsernameOrEmail(username: String, email: String): User?
}
