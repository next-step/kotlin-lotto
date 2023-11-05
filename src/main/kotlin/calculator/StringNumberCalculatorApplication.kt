package calculator

import calculator.component.StringNumberCalculator
import calculator.component.StringNumberParser

fun main() {
    val parser = StringNumberParser()
    val calculator = StringNumberCalculator(parser)

    print("입력: ")
    val input = readlnOrNull()

    val result = calculator.calculate(input)
    println("결과: $result")
}
