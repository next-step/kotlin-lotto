package stringaddcalculator

// 이전 코드
object DelimiterFinder {
    fun find(formula: String): List<String> {
        val customDelimiter = Regex(Pattern.CUSTOM_DELIMITER).find(formula)

        customDelimiter?.let {
            return DEFAULT_DELIMITER + listOf(customDelimiter.groupValues[1])
        }

        return DEFAULT_DELIMITER
    }

    private val DEFAULT_DELIMITER = listOf(":", ",")
}
