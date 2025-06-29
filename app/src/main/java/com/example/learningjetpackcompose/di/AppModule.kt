package com.example.learningjetpackcompose.di

import com.example.learningjetpackcompose.data.local.UserDao
import com.example.learningjetpackcompose.data.remote.UserService
import com.example.learningjetpackcompose.data.repository.UserRepository
import com.example.learningjetpackcompose.data.repository.UserRepositoryImp
import com.example.learningjetpackcompose.viewmodel.Viewmodel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserRepository(
        apiService: UserService,
        userDao: UserDao
    ): UserRepository
    {
        return UserRepositoryImp(apiService,userDao)
    }
    @Provides
    fun provideUserViewmodel(userRepository: UserRepository) = Viewmodel(userRepository)
}