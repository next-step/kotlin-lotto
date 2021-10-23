package calculator

import calculator.domain.InputExpressionParser
import calculator.domain.StringAddCalculator
import calculator.view.ConsoleInputView
import calculator.view.ConsoleResultView

fun main() {
    CalculatorLauncher(
        ConsoleInputView(),
        ConsoleResultView(),
        StringAddCalculator(InputExpressionParser())
    ).launch()
}
