package calculator.model

object AddCalculator {
    private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
    private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return 0
        }

        val customDelimiterAndTokens = CUSTOM_DELIMITER_REGEX.find(input)
        customDelimiterAndTokens?.let {
            return sum(customDelimiterAndTokens.groupValues[1].toRegex(), customDelimiterAndTokens.groupValues[2])
        }

        return sum(tokens = input)
    }

    private fun sum(delimiter: Regex = DEFAULT_DELIMITER_REGEX, tokens: String): Int {
        val numbers = tokens.split(delimiter)
        return Numbers.from(numbers).sum()
    }
}
