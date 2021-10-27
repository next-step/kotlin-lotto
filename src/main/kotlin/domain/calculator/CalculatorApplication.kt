package domain.calculator

import domain.calculator.domain.expression.Expression
import domain.calculator.service.Calculator
import domain.calculator.strategy.CustomSeparatorRegexStrategy
import domain.calculator.ui.InputView
import domain.calculator.ui.ResultView
import global.strategy.ConsoleInputStrategy
import global.strategy.ConsoleOutputStrategy

class CalculatorApplication(
    private val inputView: InputView,
    private val resultView: ResultView
) {
    fun execute() {
        val expression = expression()
        val calculateResult = Calculator.calculate(expression)
        resultView.output(calculateResult.result.toString())
    }

    private fun expression(): Expression {
        return try {
            Expression(inputView.inputExpression(), CustomSeparatorRegexStrategy)
        } catch (e: Exception) {
            e.message?.let(resultView::output)
            expression()
        }
    }
}

fun main() {
    val resultView = ResultView(ConsoleOutputStrategy)
    val inputView = InputView(ConsoleOutputStrategy, ConsoleInputStrategy)
    val calculatorApplication = CalculatorApplication(inputView, resultView)
    calculatorApplication.execute()
}
