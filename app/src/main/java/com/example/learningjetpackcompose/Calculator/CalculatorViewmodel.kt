package com.example.learningjetpackcompose.Calculator

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewmodel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        Log.d("CalculatorAction", "Action received: $action")

        when (action) {
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Delete -> performDeletion()
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
        }

    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null){
            val result = when (state.operation){
                CalculateOperation.Add -> number1 + number2
                CalculateOperation.Divide -> number1 / number2
                CalculateOperation.Multiply -> number1 * number2
                CalculateOperation.Subtract -> number1 - number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }

    }

    private fun enterOperation(operation: CalculateOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterNumber(i: Int) {
        Log.d("CalculatorDebug", "Number entered: $i")
      if (state.operation == null){
          if (state.number1.length >= MAX_NUM_LENGTH){
              return
          }
          state = state.copy(
              number1 = state.number1 + i
          )
          return
      }
        if (state.operation != null && state.number2.length >= MAX_NUM_LENGTH){
            return
        }
        state = state.copy(
            number2 = state.number2 + i
        )
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }


    }
    companion object{
        private const val MAX_NUM_LENGTH = 8


    }
}