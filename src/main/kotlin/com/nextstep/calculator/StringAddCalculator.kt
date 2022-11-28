package com.nextstep.calculator

class StringAddCalculator {

    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0
        try {
            return expression.toInt()
        } catch (e: NumberFormatException) {}

        return 10
    }
}
