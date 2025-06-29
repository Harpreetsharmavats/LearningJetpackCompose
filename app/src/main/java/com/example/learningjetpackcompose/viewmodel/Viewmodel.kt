package com.example.learningjetpackcompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningjetpackcompose.data.models.Users
import com.example.learningjetpackcompose.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Viewmodel @Inject constructor(
private val repository: UserRepository
) : ViewModel()  {
     val users : Flow<List<Users>> = repository.getUsers()

    fun refreshUsers(){
        viewModelScope.launch {
            repository.refreshUser()
        }

    }
}

