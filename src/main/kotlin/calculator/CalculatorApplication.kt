package calculator

import calculator.domain.StringAddCalculator
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val stringAddCalculator = StringAddCalculator(inputView.inputString())
    val result = stringAddCalculator.calculate()
    resultView.printResult(result)
}
