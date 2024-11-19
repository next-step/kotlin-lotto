package caculator

class StringCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val matchResults = extractCustomDelimiter(input)

        if (matchResults != null) {
            val customDelimiter = matchResults.groupValues[1]
            val token = matchResults.groupValues[2]
            return calculate(extractNumbers(token, customDelimiter))
        }

        return calculate(extractNumbers(input))
    }

    private fun calculate(numbers: List<String>): Int = numbers.sumOf { it.toInt() }

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
    }
}
