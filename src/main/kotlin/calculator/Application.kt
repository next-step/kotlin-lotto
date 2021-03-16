package calculator

import calculator.domain.Calculator
import calculator.view.InputConsole
import calculator.view.OutputConsole

fun main() {
    val input = InputConsole.run()
    val result = Calculator.run(input)
    OutputConsole.showResult(result)
}
