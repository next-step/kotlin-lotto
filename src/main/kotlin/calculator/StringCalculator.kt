package calculator

class StringCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        val numbers: List<PositiveNumber> =
            (useCustomDelimiter(input) ?: useDefaultDelimiter(input)).map { PositiveNumber.of(it) }
        return numbers.sumOf { it.num }
    }

    private fun useCustomDelimiter(input: String): List<String>? {
        val result = CUSTOM_DELIMITER_PATTERN_REGEX.find(input)
        return result
            ?.destructured
            ?.let { (customDelimiter, expression) ->
                expression.split(customDelimiter)
            }
    }

    private fun useDefaultDelimiter(input: String): List<String> {
        return input.split(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_COLON = ":"

        private val CUSTOM_DELIMITER_PATTERN_REGEX = "//(.)\n(.*)".toRegex()
    }
}
