package caculator

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val matchResults = extractCustomDelimiter(input)

        if (matchResults != null) {
            return calculate(extractNumbers(input = matchResults.groupValues[2], delimiter = matchResults.groupValues[1]))
        }

        return calculate(extractNumbers(input))
    }

    private fun calculate(numbers: List<String>): Int {
        val sum = numbers.sumOf { it.toInt().takeIf { it >= 0 } ?: throw RuntimeException(NUMBER_ERROR_MESSAGE) }

        return sum
    }

    private fun extractCustomDelimiter(input: String): MatchResult? {
        return Regex(CUSTOM_DELIMITER_KEYWORD).find(input)
    }

    private fun extractNumbers(
        input: String,
        delimiter: String = DEFAULT_DELIMITER_REGEX,
    ): List<String> = input.split(delimiter.toRegex())

    companion object {
        private const val DEFAULT_DELIMITER_REGEX = ",|:"
        private const val CUSTOM_DELIMITER_KEYWORD = "//(.)\\n(.*)"
        private const val NUMBER_ERROR_MESSAGE = "숫자는 음수가 될 수 없습니다."
    }
}
