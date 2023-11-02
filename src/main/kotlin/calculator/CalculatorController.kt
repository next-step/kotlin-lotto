package calculator

import calculator.app.StringCalculator
import calculator.component.Sanitizer
import calculator.component.Tokenizer
import calculator.view.ConsoleView

fun main() {
    val input = ConsoleView.inputFormula()
    val sanitizedInput = Sanitizer.sanitize(input)
    val formula = Tokenizer.tokenize(sanitizedInput)
    val result = StringCalculator.calculate(formula)
    ConsoleView.outputResult(result)
}
