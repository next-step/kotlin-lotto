package calculator

import calculator.app.StringCalculator
import calculator.component.ConsolePresenter
import calculator.component.Tokenizer
import calculator.component.Validator

fun main() {
    val consolePresenter = ConsolePresenter()
    val tokenizer = Tokenizer()
    val validator = Validator()
    val calculator = StringCalculator()

    val input = consolePresenter.inputFormula()
    val vInput = validator.validate(input)
    val tokens = tokenizer.tokenize(vInput)
    val result = calculator.calculate(tokens)
    consolePresenter.outputResult(result)
}
