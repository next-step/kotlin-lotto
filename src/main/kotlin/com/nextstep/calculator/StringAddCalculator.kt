package com.nextstep.calculator

class StringAddCalculator {
    private val defaultDelimiters = arrayOf(":", ",")
    private val customDelimiterPattern = "//(.)\n(.*)"

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        val (delimiters, expression) = parse(input)

        return expression.split(delimiters = delimiters)
            .stream()
            .mapToInt { toInt(it) }
            .map { validate(it) }
            .sum()
    }

    private fun parse(input: String): Pair<Array<String>, String> {
        val matches = Regex(customDelimiterPattern).find(input)
        matches?.run {
            return Pair(arrayOf(groupValues[1]), groupValues[2])
        }
        return Pair(defaultDelimiters, input)
    }

    private fun toInt(num: String): Int {
        try {
            return num.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException()
        }
    }

    private fun validate(number: Int): Int {
        require(number >= 0) { throw IllegalArgumentException() }
        return number
    }
}
