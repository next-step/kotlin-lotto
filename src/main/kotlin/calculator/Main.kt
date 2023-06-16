package calculator

import calculator.view.InputView
import calculator.view.ResultView

fun main() {
    val input = InputView
    val output = ResultView
    val calculatorExecuter = CalculatorExecuter(input, output)
    calculatorExecuter.execute()
}
