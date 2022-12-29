package plus_calculator

import plus_calculator.domain.StringAddCalculator
import plus_calculator.view.InputView
import plus_calculator.view.OutputView

fun main() {
    val expression = InputView.input()
    val stringAddCalculator = StringAddCalculator()

    OutputView.printResult(stringAddCalculator.add(expression))
}