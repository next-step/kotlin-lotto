package domain.calculator

import domain.calculator.domain.Expression
import domain.calculator.ui.InputView
import domain.calculator.ui.ResultView
import global.strategy.ConsoleInputStrategy
import global.strategy.ConsoleOutputStrategy

class CalculatorApplication(
    private val inputView: InputView,
    private val resultView: ResultView
) {
    fun execute() {
        val inputExpression = expression()
    }

    private fun expression(): Expression {
        return try {
            Expression(inputView.inputExpression())
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
