package calculator

import calculator.app.StringCalculator
import calculator.component.Tokenizer
import calculator.view.ConsoleView

fun main() {
    val input = ConsoleView.inputFormula()
    val formula = Tokenizer.tokenize(input)
    val result = StringCalculator.calculate(formula)
    ConsoleView.outputResult(result)
}
