package calculator

import calculator.domain.StringAddCalculator
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val stringAddCalculator = StringAddCalculator(InputView.inputString())
    val result = stringAddCalculator.calculate()

    ResultView.printResult(result)
}
