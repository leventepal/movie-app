package com.ueo.movieapp

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.ueo.movieapp.database.AppDatabase
import com.ueo.movieapp.database.User

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        App.instance = this

        Log.d("MovieApp", "onCreate()")

        this.database = Room.databaseBuilder(
            this,
            AppDatabase::class.java, "database-name"
        )
            .allowMainThreadQueries()
            .build()
    }

}