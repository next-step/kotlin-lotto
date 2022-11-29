package calculator.`in`

import calculator.view.ConsoleInput
import calculator.view.ConsoleOutput

class CalculatorController(private val input: ConsoleInput, private val outPut: ConsoleOutput) {
    fun start() {
        input.getExpression()
    }
}
