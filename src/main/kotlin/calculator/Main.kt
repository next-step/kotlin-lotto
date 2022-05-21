package calculator

import calculator.domain.Calculator

/**
 * Created by Jaesungchi on 2022.05.21..
 */

fun main() {
    val input = readLine()
    val output = Calculator.getResultOfCalculate(input)
    println(output)
}
