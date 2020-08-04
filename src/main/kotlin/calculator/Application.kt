package calculator

import calculator.domain.Calculator
import calculator.domain.Number
import calculator.domain.findCustomDelimiter
import calculator.domain.parse
import calculator.domain.validate
import calculator.presentation.InputView
import calculator.presentation.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val text = InputView.inputString()

        val validatedText = validate(text)
        val customDelimiter = findCustomDelimiter(validatedText)
        val list = parse(validatedText, customDelimiter)
        val numbers = list.filter { Number(it).isNatural() }.map { it.toInt() }
        val sum = Calculator().sum(numbers)

        ResultView.show(sum)
    }
}
