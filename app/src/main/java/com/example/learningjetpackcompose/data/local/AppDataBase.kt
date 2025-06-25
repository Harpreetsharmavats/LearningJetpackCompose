package com.example.learningjetpackcompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.learningjetpackcompose.data.models.Users


@Database(entities = [Users::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao() : UserDao

}