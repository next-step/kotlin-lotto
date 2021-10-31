package calculator.application

import calculator.domain.Calculator
import calculator.domain.Expression

class CalculatorService(
    private val calculator: Calculator,
) {
    fun execute(input: String?): Int {
        val expressions = Expression.from(input)
        return calculator.calculate(expressions)
    }
}
