package stringcalculator

private const val BASE_DELIMITER = ","
private val DELIMITER_GROUP = "[$BASE_DELIMITER:]".toRegex()
private const val CUSTOM_DELIMITER_INPUT = "//(.)\n(.*)"
private const val CUSTOM_DELIMITER_INDEX = 1
private const val CUSTOM_DELIMITER_TEXT_INDEX = 2

internal fun split(text: String): List<String> {
    Regex(CUSTOM_DELIMITER_INPUT).find(text)?.let {
        val customDelimiter = it.groupValues[CUSTOM_DELIMITER_INDEX]
        val convertedText = it.groupValues[CUSTOM_DELIMITER_TEXT_INDEX].split(customDelimiter).joinToString(BASE_DELIMITER)
        return split(convertedText)
    }

    return text.split(DELIMITER_GROUP)
}
