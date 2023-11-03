package calculator

import calculator.app.Calculator
import calculator.view.ConsoleView

fun main() {
    val input = ConsoleView.inputFormula()
    val result = Calculator.calculate(input)
    ConsoleView.outputResult(result)
}
