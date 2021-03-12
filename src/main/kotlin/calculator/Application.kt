package calculator

import calculator.domain.Calculator
import calculator.domain.Translator
import calculator.view.InputConsole
import calculator.view.OutputConsole

fun main() {
    val input = InputConsole.run()
    val tokens = Translator.run(input)
    val result = Calculator.run(tokens)
    OutputConsole.showResult(result)
}
