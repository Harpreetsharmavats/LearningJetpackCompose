package com.example.learningjetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.example.learningjetpackcompose.data.local.AppDataBase
import com.example.learningjetpackcompose.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDataBase{
        return Room.databaseBuilder(context, AppDataBase::class.java,"database").build()
    }
    @Provides
    fun provideDao(appDataBase: AppDataBase): UserDao{
        return appDataBase.userDao()

    }
}