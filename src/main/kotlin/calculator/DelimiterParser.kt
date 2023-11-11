package calculator

object DelimiterParser {

    private val DEFAULT_DELIMITER = listOf(",", ":")
    private val CUSTOM_DELIMITER_PATTERN = Regex("""//(.*)\\n(.*)""")
    private const val CUSTOM_DELIMITER_DECLARATIONS_SECTION = 1
    private const val PURE_INPUT_EXCLUDING_CUSTOM_DELIMITER_DECLARATIONS_SECTION = 2

    fun extractDelimiters(input: String): Delimiters {
        val customDelimiterMatchResult = CUSTOM_DELIMITER_PATTERN.find(input)
        val delimiters = customDelimiterMatchResult?.let {
            DEFAULT_DELIMITER + it.groupValues[CUSTOM_DELIMITER_DECLARATIONS_SECTION]
        } ?: DEFAULT_DELIMITER

        return Delimiters(delimiters)
    }

    fun extractInputWithoutDelimiterDeclarations(input: String): String =
        CUSTOM_DELIMITER_PATTERN.find(input)?.let {
            it.groupValues[PURE_INPUT_EXCLUDING_CUSTOM_DELIMITER_DECLARATIONS_SECTION]
        } ?: input
}
