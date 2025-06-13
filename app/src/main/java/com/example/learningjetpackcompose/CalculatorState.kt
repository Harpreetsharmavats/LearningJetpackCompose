package com.example.learningjetpackcompose

data class CalculatorState(
    var number1 : String = "",
    val number2 : String = "",
    val operation: CalculateOperation? = null
)
