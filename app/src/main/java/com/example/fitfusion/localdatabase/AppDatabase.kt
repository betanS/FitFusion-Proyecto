package com.example.fitfusion.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Training::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val dao: UserDao
}
