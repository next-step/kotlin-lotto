package calculator

import calculator.domain.StringAddCalculator
import calculator.usecase.SplitParser
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val parser = SplitParser()
    val calculator = StringAddCalculator(parser)

    val input = inputView.input()

    val result = calculator.calculate(input)

    resultView.show(result)
}
