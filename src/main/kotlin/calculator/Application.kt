package calculator

import calculator.domain.Calculator
import calculator.domain.Number
import calculator.domain.parse
import calculator.domain.validate
import calculator.presentation.InputView
import calculator.presentation.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val text = InputView.inputString()

        val validatedText = validate(text)
        val list = parse(validatedText)
        val numbers = list.map { Number(it).isNature() }
        val sum = Calculator().sum(numbers)

        ResultView.show(sum)
    }
}
