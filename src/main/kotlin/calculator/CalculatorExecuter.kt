package calculator

import calculator.expression.Expression
import calculator.view.InputView
import calculator.view.ResultView

class CalculatorExecuter(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun execute() {
        val input = inputView.readInput()
        val expression = Expression.of(input)
        val addCalculator = AddCalculator(expression)
        val result = addCalculator.add()
        resultView.printResult(result)
    }
}
