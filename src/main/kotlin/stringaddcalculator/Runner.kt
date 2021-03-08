package stringaddcalculator

import stringaddcalculator.domain.StringAddCalculator

fun main(args: Array<String>) {
    val calculationInput = readLine()
    val calculationResult = StringAddCalculator().calculate(calculationInput)
    println(calculationResult)
}
