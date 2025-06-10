package com.example.learningjetpackcompose

sealed class CalculateOperation(val symbol: String) {
    object Add : CalculateOperation("+")
    object Subtract : CalculateOperation("-")
    object Multiply : CalculateOperation("x")
    object Divide : CalculateOperation("/")
}