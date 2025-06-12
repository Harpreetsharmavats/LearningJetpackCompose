package com.example.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme
import com.example.learningjetpackcompose.ui.theme.MediumGrey


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearningJetpackComposeTheme {
                val viewmodel = viewModel<CalculatorViewmodel>()
                val state = viewmodel.state
                val buttonSpacing = 8.dp
                Calculator(
                    state = state, onAction = viewmodel::onAction,
                buttonSpacing = buttonSpacing,
                    modifier = Modifier.fillMaxSize()
                        .background(MediumGrey)
                        .padding(16.dp))
            }
        }
    }
}

