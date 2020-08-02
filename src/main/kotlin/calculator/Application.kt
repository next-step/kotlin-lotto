package calculator

import calculator.infrastructure.Calculator
import calculator.infrastructure.Number
import calculator.infrastructure.findCustomDelimiter
import calculator.infrastructure.parse
import calculator.infrastructure.validate
import calculator.presentation.InputView
import calculator.presentation.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputString = InputView.inputString()

        val validatedString = validate(inputString)
        val customDelimiter = findCustomDelimiter(validatedString)
        val list = parse(validatedString, customDelimiter)
        val numbers = list.filter { Number(it).isNatural() }.map { it.toInt() }
        val sum = Calculator().sum(numbers)

        ResultView.show(sum)
    }
}
