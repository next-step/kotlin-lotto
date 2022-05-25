package com.nextstep.jngcii.calculator

fun main() {
    val inputView = InputView(InputParser)
    val numbers = inputView.getNumbers { readLine() }
    val result = Calculator.run(numbers)
    ResultView.print(result)
}
