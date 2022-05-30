package calculator

import calculator.domain.Expression

class StringAddCalculator {

    fun add(expression: Expression): Int {
        var result = 0

        expression.operands.forEach {
            result += it.value
        }

        return result
    }
}
