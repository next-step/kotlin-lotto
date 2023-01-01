package com.nextstep.calculator

class StringAddCalculator {
    private val regex = Regex("//(.)\n(.*)")

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0
        return createExpression(input).calculate()
    }

    private fun createExpression(input: String): Expression {
        val matches = regex.find(input)
        if (matches != null) {
            return Expression(delimiters = arrayOf(matches.groupValues[1]), expression = matches.groupValues[2])
        }
        return Expression(expression = input)
    }

    class Expression(private val expression: String, private vararg val delimiters: String = arrayOf(":", ",")) {
        fun calculate() = expression.split(delimiters = delimiters)
            .map { toInt(it) }
            .sumOf { validateAndReturn(it) }

        private fun toInt(num: String): Int {
            return num.toIntOrNull() ?: throw IllegalArgumentException()
        }

        private fun validateAndReturn(number: Int): Int {
            require(number >= 0) { "음수는 입력할 수 없습니다, number: $number" }
            return number
        }
    }
}
