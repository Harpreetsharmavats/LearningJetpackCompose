package com.example.learningjetpackcompose.data.repository

import android.net.http.HttpException
import android.util.Log
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
        try {
            val users = userService.getUser()
            userDao.insertAll(users)

        }catch (e : retrofit2.HttpException){
            Log.e("UserService","401")
        }


    }


}

