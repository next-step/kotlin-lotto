package calculator

import calculator.expression.Expression

class AddCalculator(
    private val expression: Expression
) {
    fun add(): Int {
        return expression.sum()
    }
}
