package com.example.learningjetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewmodel: ViewModel() {
    val state by mutableStateOf(CalculatorState())
        private set
}