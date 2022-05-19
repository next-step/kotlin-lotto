package stringAddCalculator

object DelimiterFinder {
    fun find(formula: String): List<String> {
        val customDelimiter = Regex("//(.)\n(.*)").find(formula)

        customDelimiter?.let {
            return DEFAULT_DELIMITER + listOf(customDelimiter.groupValues[1])
        }

        return DEFAULT_DELIMITER
    }

    private val DEFAULT_DELIMITER = listOf(":", ",")
}