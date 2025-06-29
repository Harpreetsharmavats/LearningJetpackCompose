package com.example.learningjetpackcompose

import com.example.learningjetpackcompose.di.AppModule
import com.example.learningjetpackcompose.di.DatabaseModule
import com.example.learningjetpackcompose.di.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class, AppModule::class])
interface AppComponent {
    fun inject(application: Application)
}