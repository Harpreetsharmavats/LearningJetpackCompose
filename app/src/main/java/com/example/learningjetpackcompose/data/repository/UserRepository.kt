package com.example.learningjetpackcompose.data.repository

import com.example.learningjetpackcompose.data.models.Users
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUsers() : Flow<List<Users>>
    suspend fun refreshUser()
}