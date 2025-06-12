package com.example.learningjetpackcompose

import android.hardware.lights.Light
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.learningjetpackcompose.ui.theme.LightGrey
import com.example.learningjetpackcompose.ui.theme.Orange

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                color = androidx.compose.ui.graphics.Color.White,
                maxLines = 2
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculationButton(
                symbol = "AC",
                modifier = Modifier.background(LightGrey)
                    .aspectRatio(2f)
                    .weight(2f),
                onClick = {onAction(CalculatorAction.Clear)}
            )
            CalculationButton(
                symbol = "DEL",
                modifier = Modifier.background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {onAction(CalculatorAction.Delete)}
            )
            CalculationButton(
                symbol = "/",
                modifier = Modifier.background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {onAction(CalculatorAction.Operation(CalculateOperation.Divide))}
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            CalculationButton(
                symbol = "AC",
                modifier = Modifier.background(LightGrey)
                    .aspectRatio(2f)
                    .weight(2f),
                onClick = {onAction(CalculatorAction.Clear)}
            )
            CalculationButton(
                symbol = "DEL",
                modifier = Modifier.background(LightGrey)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {onAction(CalculatorAction.Delete)}
            )
            CalculationButton(
                symbol = "/",
                modifier = Modifier.background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = {onAction(CalculatorAction.Operation(CalculateOperation.Divide))}
            )
        }
    }


}