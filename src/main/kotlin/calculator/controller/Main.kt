package calculator

import calculator.domain.Calculator
import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val text = InputView.getInput()
    val calculator = Calculator()
    calculator.calculate(text)
    ResultView.printResult(calculator.result)
}
