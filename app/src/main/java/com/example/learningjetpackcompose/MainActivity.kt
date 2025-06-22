package com.example.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningjetpackcompose.Calculator.Calculator
import com.example.learningjetpackcompose.Calculator.CalculatorViewmodel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewmodel: CalculatorViewmodel = viewModel()
            val state = viewmodel.state
            Calculator(
                state = state,
                onAction = viewmodel::onAction,

                )

        }
    }
}

