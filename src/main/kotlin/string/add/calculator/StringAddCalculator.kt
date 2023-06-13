package string.add.calculator

import com.sun.tools.javac.jvm.ByteCodes.ret

class StringAddCalculator {
    private val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

    fun add(text: String?): Int {
        return calculateOrDefault(text)
    }

    private fun calculateOrDefault(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return 0
        }

        if (text.isBlank()) {
            return 0
        }

        return calculate(text)
    }

    private fun calculate(text: String): Int {
        val numberStrings = parseText(text)
        val numbers = convertToIntList(numberStrings)

        return numbers.sum()
    }

    private fun parseText(text: String): List<String> {
        var textAfterCustomDelimiter = text

        findCustomDelimiter(text)?.let {
            delimiters.add(it)
            textAfterCustomDelimiter = text.substringAfter(CUSTOM_DELIMITER_END)
        }

        return textAfterCustomDelimiter.split(*delimiters.toTypedArray())
    }

    private fun findCustomDelimiter(text: String): String? {
        val result = Regex("//(.)\n(.*)").find(text)
        return result?.groupValues?.get(1)
    }

    private fun convertToIntList(numberStrings: List<String>): List<Int> {
        val numbers = numberStrings.map {
            it.toIntOrNull() ?: throw RuntimeException(ErrorMessage.NON_NUMERIC_VALUE_WAS_PASSED.message)
        }

        validateNumbers(numbers)
        return numbers
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException(ErrorMessage.NEGATIVE_NUMBER_PASSED.message)
        }
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA: String = ","
        private const val DEFAULT_DELIMITER_COLON: String = ":"
        private const val CUSTOM_DELIMITER_END: String = "\n"
    }
}
