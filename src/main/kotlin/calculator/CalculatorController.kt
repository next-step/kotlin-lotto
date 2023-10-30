package calculator

import calculator.app.StringCalculator
import calculator.view.ConsoleView
import calculator.component.Tokenizer
import calculator.component.Validator

fun main() {
    val consoleView = ConsoleView()
    val tokenizer = Tokenizer()
    val validator = Validator()
    val calculator = StringCalculator()

    val input = consoleView.inputFormula()
    val vInput = validator.validate(input)
    val tokens = tokenizer.tokenize(vInput)
    val result = calculator.calculate(tokens)
    consoleView.outputResult(result)
}
