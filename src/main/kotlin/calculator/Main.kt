package calculator

import calculator.domain.StringAddCalculator
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val stringAddCalculator = StringAddCalculator()

    val text = inputView.inputExpression()
    val result = stringAddCalculator.calculate(text)
    resultView.outputCalculateResult(result)
}
