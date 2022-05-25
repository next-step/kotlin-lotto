package string_calculator

private val CUSTOM_LOG_REGEX = Regex("//(.)\n(.*)")
private val BASIC_DELIMITER = listOf(",", ":")

object StringSeparator {
    fun splitToDelimitersAndNumbers(text: String): Pair<List<String>, String> {
        CUSTOM_LOG_REGEX.find(text)?.let {
            return BASIC_DELIMITER.plus(it.groupValues[1]) to it.groupValues[2]
        }

        return BASIC_DELIMITER to text
    }
}
