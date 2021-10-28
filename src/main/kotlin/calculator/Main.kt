package calculator

import calculator.domain.CalculatorImpl
import calculator.usecase.SplitParser
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val calculator = CalculatorImpl(SplitParser())

    val input = inputView.input()

    val result = calculator.calculate(input)

    resultView.show(result)
}
