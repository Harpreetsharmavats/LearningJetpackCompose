package com.example.learningjetpackcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learningjetpackcompose.data.models.Users
import com.example.learningjetpackcompose.viewmodel.Viewmodel


@Composable
fun UserListScreen(viewModel: Viewmodel = hiltViewModel()) {
    val users = viewModel.users.collectAsState(initial = emptyList())

    Column {
        Text(text = "User List")
        LazyColumn {
            items(users.value) { user ->
                UserItem(user)
            }
        }
    }

    LaunchedEffect (Unit) {
        viewModel.refreshUsers()
    }
}




@Composable
fun UserItem(user: Users) {
    Text(text = user.name)
}
