package com.example.learningjetpackcompose

 sealed class CalculatorAction {
  data class Number(val number: Int): CalculatorAction()
  object Clear : CalculatorAction()
  object Delete : CalculatorAction()
  object Decimal : CalculatorAction()
  object Calculate: CalculatorAction()
  data class Operation( val operation: CalculateOperation) : CalculatorAction()
}