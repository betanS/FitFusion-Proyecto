package com.example.fitfusion.localdatabase

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
    fun getUserByEmail(email: String): Flow<List<User>>

    // Nuevas funciones para comprobar si el usuario o el correo electrónico ya existen
    @Query("SELECT * FROM user WHERE username = :username OR email = :email")
    fun getUserByUsernameOrEmail(username: String, email: String): Flow<List<User>>

    @Insert
    suspend fun insertTraining(training: Training)

    @Query("SELECT * FROM training")
    fun getAllTrainings(): Flow<List<Training>>

    @Query("SELECT * FROM training WHERE id = :id")
    fun getTrainingById(id: Int): Flow<List<Training>>
}
