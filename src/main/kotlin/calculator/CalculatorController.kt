package calculator

import calculator.app.StringCalculator
import calculator.component.Tokenizer
import calculator.component.Validator
import calculator.view.ConsoleView

fun main() {
    val input = ConsoleView.inputFormula()
    val validatedInput = Validator.validate(input)
    val formula = Tokenizer.tokenize(validatedInput)
    val result = StringCalculator.calculate(formula)
    ConsoleView.outputResult(result)
}
