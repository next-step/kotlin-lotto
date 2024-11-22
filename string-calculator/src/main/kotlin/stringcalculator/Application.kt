package stringcalculator

import stringcalculator.StringParser.splitToInt

class Application

fun main() {
    val input = InputView.inputString()

    val numbers = input.splitToInt()

    println(numbers.sum())
}
