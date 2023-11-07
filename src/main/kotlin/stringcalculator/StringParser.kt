package stringcalculator

object StringParser {
    private const val CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)"
    private const val DEFAULT_DELIMITERS = ",|:"

    fun findCustomDelimiterAndNumbers(text: String?): Pair<String, String> {
        val result = Regex(CUSTOM_DELIMITER_REGEX).find(text.orEmpty())
        return when {
            result != null -> result.groupValues[1] to result.groupValues[2]
            else -> DEFAULT_DELIMITERS to text.orEmpty()
        }
    }

    fun splitByDelimiter(text: String, delimiter: String): List<String> {
        return text.split(delimiter.toRegex())
    }
}
