package calculator.`in`

import calculator.domain.Calculator
import calculator.domain.Expression
import calculator.view.ConsoleInput
import calculator.view.ConsoleOutput

class CalculatorController(private val input: ConsoleInput, private val outPut: ConsoleOutput) {
    fun start() {
        val expression = input.getExpression()
        val tokens = Expression.split(expression)
        val result = Calculator.calculate(tokens)
        outPut.printResult(expression, result)
    }
}
