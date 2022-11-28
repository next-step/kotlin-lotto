package com.nextstep.calculator

class StringAddCalculator {

    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0

        val matches = Regex("//(.)\n(.*)").find(expression)
        matches?.let {
            val delimiter = it.groupValues[1]
            return it.groupValues[2].split(delimiter)
                .stream()
                .mapToInt { it -> it.toInt() }
                .sum()
        }

        return expression.split(":", ",")
            .stream()
            .mapToInt { it.toInt() }
            .sum()
    }
}
