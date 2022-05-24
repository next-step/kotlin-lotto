package com.nextstep.jngcii.calculator

fun main() {
    val inputParser = InputParser
    val inputView = InputView(inputParser)
    val resultView = ResultView
    val calculator = Calculator

    val numbers = inputView.getNumbers()
    val result = calculator.run(numbers)
    resultView.print(result)
}
