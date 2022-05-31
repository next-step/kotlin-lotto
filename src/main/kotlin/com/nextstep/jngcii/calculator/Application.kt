package com.nextstep.jngcii.calculator

fun main() {
    val numbers = InputView.getNumbers(readLine())
    val result = Calculator.run(numbers)
    ResultView.print(result)
}
