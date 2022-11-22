package calculator.controller

import calculator.domain.Calculator
import calculator.domain.InputParser
import calculator.domain.PositiveOperand
import calculator.view.InputView
import calculator.view.ResultView

class Controller {
    fun start() {
        val numbers = InputParser().parseWithDelimiter(InputView.inputFormula())
        val positiveOperands = numbers.map { PositiveOperand(it) }.toTypedArray()
        val result = Calculator().add(positiveOperands).value
        ResultView.printResult(result)
    }
}
