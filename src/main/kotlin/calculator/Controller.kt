package calculator

import calculator.app.Calculator
import calculator.model.Tokenizer
import calculator.view.ConsoleView

fun main() {
    val input = ConsoleView.inputFormula()
    val formula = Tokenizer.tokenize(input)
    val result = Calculator.calculate(formula)
    ConsoleView.outputResult(result)
}
