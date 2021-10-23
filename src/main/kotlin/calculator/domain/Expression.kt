package calculator.domain

import calculator.exception.InvalidExpressionException

class Expression(
    private val value: String? = null,
) {
    fun prepareCalculation(): List<Int> {
        val expressions = segregateExpressions()
        return validateExpressions(expressions)
    }

    private fun segregateExpressions(): List<String> {
        if (value.isNullOrBlank()) {
            return listOf(ZERO)
        }
        if (value == "1") {
            return listOf(ONE)
        }
        val result: MatchResult? = customRegex.find(value)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        return value.split(DELIMITER_COMMA, DELIMITER_COLON)
    }

    private fun validateExpressions(expressions: List<String>): List<Int> {
        val numbers = mutableListOf<Int>()
        expressions.forEach { number ->
            validateNumber(number)
            numbers.add(number.toInt())
        }
        return numbers.toList()
    }

    private fun validateNumber(element: String) {
        if (!numberRegex.containsMatchIn(element) || element.toInt() < 0) {
            throw InvalidExpressionException()
        }
    }

    companion object {
        private val numberRegex: Regex = Regex("[0-9]")
        private val customRegex: Regex = Regex("//(.)\n(.*)")

        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val ZERO = "0"
        private const val ONE = "1"
    }
}
