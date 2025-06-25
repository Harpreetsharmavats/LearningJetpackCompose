package com.example.learningjetpackcompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningjetpackcompose.data.models.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao  {
    @Query("SELECT * FROM users")
    fun getUser() : Flow<List<Users>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll (users: List<Users>)
}