package calculator

import calculator.domain.StringAddCalculator
import calculator.view.InputView

fun main() {
    val inputView = InputView()
    val stringAddCalculator = StringAddCalculator(inputView.inputString())

    val result = stringAddCalculator.calculate()
    println(result)
}
