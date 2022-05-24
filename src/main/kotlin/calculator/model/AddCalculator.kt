package calculator.model

object AddCalculator {
    private const val DEFAULT_SUM = 0
    private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
    private val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)".toRegex()

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return DEFAULT_SUM
        }

        val delimiterAndTokens = CUSTOM_DELIMITER_REGEX.find(input)
        delimiterAndTokens?.let {
            return splitAndSum(delimiterAndTokens.groupValues[1].toRegex(), delimiterAndTokens.groupValues[2])
        }

        return splitAndSum(tokens = input)
    }

    private fun splitAndSum(delimiter: Regex = DEFAULT_DELIMITER_REGEX, tokens: String): Int {
        val numbers = tokens.split(delimiter)
        return PositiveNumbers.from(numbers).sum()
    }
}
