package calculator

import calculator.app.StringCalculator
import calculator.component.Tokenizer
import calculator.component.Validator
import calculator.view.ConsoleView

fun main() {

    val calculator = StringCalculator()

    val input = ConsoleView.inputFormula()
    val validatedInput = Validator.validate(input)
    val tokens = Tokenizer.tokenize(validatedInput)
    val result = calculator.calculate(tokens)
    ConsoleView.outputResult(result)
}
