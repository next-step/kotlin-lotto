package calculator

import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val expression = InputView.getExpression()
    val result = Calculator().execute(expression)

    OutputView.printResult(result)
}
