package com.Valeria.computadora.Labo4.data

import android.app.Application
import androidx.room.Room
import com.Valeria.computadora.Labo4.data.database.AppDatabase

class InitDatabase : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "AppDatabase"
        ).fallbackToDestructiveMigration().build()
    }
}
