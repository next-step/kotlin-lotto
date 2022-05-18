package calculator

object StringParser {

    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n")

    private const val REGEX_REPLACEMENT_STRING = ""
    private const val COMMA_DELIMITER = ","
    private const val SEMICOLON_DELIMITER = ";"

    fun getNumberStrings(input: String): List<String> {
        var strings = input
        val customDelimiter = CustomDelimiterFinder.find(input, CUSTOM_DELIMITER_REGEX)

        if (customDelimiter != null) {
            strings = strings.replace(CUSTOM_DELIMITER_REGEX, REGEX_REPLACEMENT_STRING)
        }
        return strings.splitAsDelimiter(customDelimiter)
    }

    private fun String.splitAsDelimiter(customDelimiter: String? = null): List<String> {
        var delimiters = arrayOf(COMMA_DELIMITER, SEMICOLON_DELIMITER)

        customDelimiter?.let {
            delimiters += it
        }

        return this.split(*delimiters)
    }
}
