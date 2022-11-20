package calculator.controller

import calculator.domain.Calculator
import calculator.domain.InputParser
import calculator.domain.Operand
import calculator.view.InputView
import calculator.view.ResultView

class Controller {
    fun start() {
        val numbers = InputParser().parseWithDelimiter(InputView.inputFormula())
        val operands = numbers.map { Operand(it) }.toTypedArray()
        val result = Calculator().add(operands).value
        ResultView.printResult(result)
    }
}
