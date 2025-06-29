package com.example.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningjetpackcompose.Calculator.Calculator
import com.example.learningjetpackcompose.Calculator.CalculatorViewmodel
import com.example.learningjetpackcompose.ui.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewmodel: CalculatorViewmodel = viewModel()
            val state = viewmodel.state
            UserListScreen()

        }
    }
}

