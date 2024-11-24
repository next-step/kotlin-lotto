package calculator

import calculator.util.deleteCustomDelimiter
import calculator.util.getCustomDelimiter

class StringAddCalculatorManager {
    fun start(input: String?): Int {
        val parsedNumbers = inputToListOrThrow(input)
        return StringAddCalculator(parsedNumbers).calculate()
    }

    fun inputToListOrThrow(input: String?): List<Int> {
        if (input.isNullOrBlank()) return emptyList()
        val parsedNumbers = split(input)
        parsedNumbers.apply { if (any { it < 0 }) throw RuntimeException() }
        return parsedNumbers
    }

    private fun split(input: String): List<Int> {
        val customDelimiter: String = getCustomDelimiter(input)
        val deletedCustomDelimiter = deleteCustomDelimiter(input)
        val regex = buildRegex(customDelimiter)

        return deletedCustomDelimiter.split(regex)
            .map { it.toInt() }
    }

    private fun buildRegex(customDelimiter: String): Regex {
        val delimiters = listOf(DELIMITER_COMMA, DELIMITER_COLON, customDelimiter)
        val escapedDelimiters =
            delimiters
                .filter { it.isNotEmpty() }
                .joinToString("|") { Regex.escape(it) }
        return Regex(escapedDelimiters)
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
    }
}
