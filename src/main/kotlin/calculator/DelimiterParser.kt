package calculator

object DelimiterParser {

    private val DEFAULT_DELIMITER = listOf(",", ":")
    private val CUSTOM_DELIMITER_PATTERN = Regex("""//(.*)\\n(.*)""")

    fun extractDelimiters(input: String): Delimiters {
        val delimiters = Delimiters()
        delimiters.add(DEFAULT_DELIMITER)

        CUSTOM_DELIMITER_PATTERN.find(input)?.let {
            delimiters.add(it.groupValues[1])
        }

        return delimiters
    }

    fun extractPureInput(input: String): String {
        return CUSTOM_DELIMITER_PATTERN.find(input)
            ?.groupValues?.get(2)
            ?: input
    }
}
