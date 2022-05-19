package calculator

class StringCalculator {
    fun calculate(input: String): Int {
        val numbers = useCustomDelimiter(input) ?: useDefaultDelimiter(input)
        return numbers.sumOf { it.toInt() }
    }

    private fun useCustomDelimiter(input: String): List<String>? {
        val result = Regex(CUSTOM_DELIMITER_PATTERN).find(input)
        result?.let {
            val customDelimiter = it.groupValues[REGEX_DELIMITER_INDEX]
            return it.groupValues[REGEX_VALUES_INDEX].split(customDelimiter)
        }
        return null
    }

    private fun useDefaultDelimiter(input: String): List<String> {
        return input.split(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)
    }
    companion object {
        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_COLON = ":"
        private const val REGEX_DELIMITER_INDEX = 1
        private const val REGEX_VALUES_INDEX = 2

        private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"
    }
}
