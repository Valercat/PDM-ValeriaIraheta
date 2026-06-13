package com.Valeria.computadora.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.Valeria.computadora.data.database.dao.PostDao
import com.Valeria.computadora.data.database.entities.Post

@Database(
    entities = [Post::class],
    version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}

