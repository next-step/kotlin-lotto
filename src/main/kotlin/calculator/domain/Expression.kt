package calculator.domain

import calculator.exception.InvalidExpressionException

class Expression(
    private val value: String? = null,
) {
    fun prepareCalculation(): List<Int> {
        val expressions = segregateExpressions()
        return convertNumbers(expressions)
    }

    private fun segregateExpressions(): List<String> {
        if (value.isNullOrBlank()) {
            return listOf(ZERO)
        }
        val result: MatchResult? = customRegex.find(value)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        return value.split(DELIMITER_COMMA, DELIMITER_COLON)
    }

    private fun convertNumbers(expressions: List<String>): List<Int> {
        return expressions.filter { validateNumber(it) }
            .map { it.toInt() }
            .toList()
    }

    private fun validateNumber(element: String): Boolean {
        if (!numberRegex.containsMatchIn(element) || element.toInt() < 0) {
            throw InvalidExpressionException()
        }
        return true
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
