package calculator

object StringParser {
    private const val COMMA_DELIMITER = ","
    private const val SEMICOLON_DELIMITER = ";"

    private const val CUSTOM_DELIMITER_INDEX = 1
    private const val NUMBER_STRING_INDEX = 2

    fun getNumberStrings(input: String): List<String> {
        val matcherResult = CustomDelimiterFinder.find(input)

        return if (matcherResult != null) {
            val delimiter = matcherResult.groupValues[CUSTOM_DELIMITER_INDEX]
            val numberStrings = matcherResult.groupValues[NUMBER_STRING_INDEX]
            numberStrings.splitAsDelimiter(delimiter)
        } else {
            input.splitAsDelimiter()
        }
    }

    private fun String.splitAsDelimiter(customDelimiter: String? = null): List<String> {
        var delimiters = arrayOf(COMMA_DELIMITER, SEMICOLON_DELIMITER)

        customDelimiter?.let {
            delimiters += it
        }

        return this.split(*delimiters)
    }
}
