package com.example.learningjetpackcompose.data.remote

import com.example.learningjetpackcompose.data.models.Users
import retrofit2.http.GET


interface UserService  {
    @GET("users")
    suspend fun getUser(): List<Users>
}