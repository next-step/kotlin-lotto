package textcalculator

import textcalculator.calculator.Calculator
import textcalculator.text.InputString

fun main() {
    startCalculate()
}

fun startCalculate() {
    println("계산할 문자열 입력:")
    val input = readlnOrNull() ?: ""
    val inputString = InputString(input)

    val result = Calculator.calculate(Calculator.splitString(inputString.input))
    println("결과: $result")
}
