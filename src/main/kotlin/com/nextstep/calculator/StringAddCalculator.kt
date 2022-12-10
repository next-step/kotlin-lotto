package com.nextstep.calculator

class StringAddCalculator {
    private val defaultDelimiters = arrayOf(":", ",")
    private val regex = Regex("//(.)\n(.*)")

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        val (delimiters, expression) = parse(input)

        return expression.split(delimiters = delimiters).map { toInt(it) }.sumOf { validateAndReturn(it) }
    }

    private fun parse(input: String): Pair<Array<String>, String> {
        val matches = regex.find(input)

        if (matches != null) {
            return Pair(arrayOf(matches.groupValues[1]), matches.groupValues[2])
        }
        return Pair(defaultDelimiters, input)
    }

    private fun toInt(num: String): Int {
        return num.toIntOrNull() ?: throw IllegalArgumentException()
    }

    private fun validateAndReturn(number: Int): Int {
        require(number >= 0) { "음수는 입력할 수 없습니다, number: $number" }
        return number
    }
}
