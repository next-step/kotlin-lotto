package com.nextstep.calculator

class StringAddCalculator {

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        var delimiters = arrayOf(":", ",")
        var expression = input

        val matches = Regex("//(.)\n(.*)").find(input)
        matches?.let {
            delimiters = arrayOf(it.groupValues[1])
            expression = it.groupValues[2]
        }

        return expression!!.split(delimiters = delimiters)
            .stream()
            .mapToInt { toInt(it) }
            .map { validate(it) }
            .sum()
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
