package calculator

import calculator.domain.AdditionCalculator
import calculator.domain.Calculator
import calculator.domain.Expression
import calculator.ui.StringCalculatorView

fun main() = StringCalculatorApplication(StringCalculatorView(), AdditionCalculator()).run()

class StringCalculatorApplication(
    private val view: StringCalculatorView,
    private val calculator: Calculator
) {
    fun run() {
        val input = view.input()
        val expression = Expression.of(input)

        view.output(calculator.calculate(expression.operands))
    }
}
