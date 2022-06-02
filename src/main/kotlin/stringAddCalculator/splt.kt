package stringAddCalculator

private const val BASE_DELIMITER = ","
private val DELIMITER_GROUP = "[$BASE_DELIMITER:]".toRegex()

internal fun split(text: String): List<String> {
    Regex("//(.)\n(.*)").find(text)?.let {
        val customDelimiter = it.groupValues[1]
        val convertedText = it.groupValues[2].split(customDelimiter).joinToString(BASE_DELIMITER)
        return split(convertedText)
    }

    return text.split(DELIMITER_GROUP)
}
