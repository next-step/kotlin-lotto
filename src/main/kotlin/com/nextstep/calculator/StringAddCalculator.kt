package com.nextstep.calculator

class StringAddCalculator {

    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0
        return expression.split(":", ",")
            .stream()
            .mapToInt { it.toInt() }
            .sum()
    }
}
