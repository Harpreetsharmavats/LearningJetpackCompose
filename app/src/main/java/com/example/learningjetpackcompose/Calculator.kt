package com.example.learningjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningjetpackcompose.ui.theme.LightGrey
import com.example.learningjetpackcompose.ui.theme.MediumGrey
import com.example.learningjetpackcompose.ui.theme.Orange
import com.example.learningjetpackcompose.ui.theme.White


@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize().background(color = Color.Black)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Normal,
                fontSize = 80.sp,
                color = White,
                maxLines = 2
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculationButton(
                    symbol = "AC",
                    modifier = Modifier.background(LightGrey)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorAction.Clear) }
                )
                CalculationButton(
                    symbol = "DEL",
                    modifier = Modifier.background(LightGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Delete) }
                )
                CalculationButton(
                    symbol = "/",
                    modifier = Modifier.background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculateOperation.Divide)) }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculationButton(
                    symbol = "7",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(7)) }
                )
                CalculationButton(
                    symbol = "8",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(8)) }
                )
                CalculationButton(
                    symbol = "9",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(9)) }
                )
                CalculationButton(
                    symbol = "x",
                    modifier = Modifier.background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculateOperation.Multiply)) }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculationButton(
                    symbol = "4",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(4)) }
                )
                CalculationButton(
                    symbol = "5",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(5)) }
                )
                CalculationButton(
                    symbol = "6",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(6)) }
                )
                CalculationButton(
                    symbol = "-",
                    modifier = Modifier.background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculateOperation.Subtract)) }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculationButton(
                    symbol = "1",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(1)) }
                )
                CalculationButton(
                    symbol = "2",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(2)) }
                )
                CalculationButton(
                    symbol = "3",
                    modifier = Modifier.background(MediumGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Number(3)) }
                )
                CalculationButton(
                    symbol = "+",
                    modifier = Modifier.background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Operation(CalculateOperation.Add)) }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculationButton(
                    symbol = "0",
                    modifier = Modifier.background(LightGrey)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = { onAction(CalculatorAction.Number(0)) }
                )
                CalculationButton(
                    symbol = ".",
                    modifier = Modifier.background(LightGrey)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Decimal) }
                )
                CalculationButton(
                    symbol = "=",
                    modifier = Modifier.background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = { onAction(CalculatorAction.Calculate) }
                )

            }
        }
    }


}