package calculator.util

import calculator.const.IllegalExpressionException
import calculator.extension.isPositiveNumeric

object Parser {
    fun parse(delimiter: List<String>, expression: String): List<Int> {
        val numbers = expression.split(*delimiter.toTypedArray())
        validateExpression(numbers)
        return numbers.map { number -> number.toInt() }
    }

    private fun validateExpression(numbers: List<String>) {
        numbers.forEach { number ->
            if (!number.isPositiveNumeric()) {
                throw IllegalExpressionException()
            }
        }
    }
}
