package calculator.domain

import calculator.exception.InvalidExpressionException

class Expression(
    private val value: String? = null,
) {
    private val regex: Regex = Regex("[0-9]")
    private val _numbers = mutableListOf<Int>()

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
        return value.split(DELIMITER_COMMA, DELIMITER_COLON)
    }

    private fun validateExpressions(expressions: List<String>): List<Int> {
        for (number in expressions) {
            validateNumber(number)
            _numbers.add(number.toInt())
        }
        return _numbers.toList()
    }

    private fun validateNumber(element: String) {
        if (!regex.containsMatchIn(element) || element.toInt() < 0) {
            throw InvalidExpressionException()
        }
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val ZERO = "0"
        private const val ONE = "1"
    }
}
