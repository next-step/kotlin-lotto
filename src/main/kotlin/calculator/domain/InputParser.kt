package calculator.domain

object InputParser {
    private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
    private const val DEFAULT_DELIMITER = ",|:"

    private const val REGEX_DELIMITER_POSITION = 1
    private const val MATCHES_STRING_POSITION = 2

    fun parse(input: String): List<String> {
        val customDelimiterMatch = CUSTOM_DELIMITER_REGEX.toRegex().find(input) ?: return parse(input, DEFAULT_DELIMITER.toRegex())

        val delimiter = customDelimiterMatch.groupValues[REGEX_DELIMITER_POSITION]
        return customDelimiterMatch.groupValues[MATCHES_STRING_POSITION].split(delimiter)
    }

    private fun parse(input: String, delimiter: Regex): List<String> {
        return input.split(delimiter)
    }
}
