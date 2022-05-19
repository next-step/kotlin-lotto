package stringaddcalculator

import stringaddcalculator.domain.StringAddCalculator

fun main() {
    val input = readLine()
    val output = StringAddCalculator().calculate(input)
    println(output)
}
