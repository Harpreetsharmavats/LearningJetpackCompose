package com.example.learningjetpackcompose.data.repository

import com.example.learningjetpackcompose.data.local.UserDao
import com.example.learningjetpackcompose.data.models.Users
import com.example.learningjetpackcompose.data.remote.UserService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao
): UserRepository {
    override fun getUsers(): Flow<List<Users>> = userDao.getUser()

    override suspend fun refreshUser() {
        val users = userService.getUser()
        userDao.insertAll(users)
    }


}

