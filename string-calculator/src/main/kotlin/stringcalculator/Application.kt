package stringcalculator

import stringcalculator.StringParser.splitToInts
import stringcalculator.StringParser.toCalculateRequest

class Application

fun main() {
    val input = InputView.inputString()

    val (delimiter, payload) = input.toCalculateRequest()
    val numbers = payload.splitToInts(delimiter)

    println(numbers.sum())
}
