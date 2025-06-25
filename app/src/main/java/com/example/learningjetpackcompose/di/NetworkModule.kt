package com.example.learningjetpackcompose.di

import com.example.learningjetpackcompose.data.remote.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
     fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit) : UserService{
        return retrofit.create(UserService::class.java)
    }
}