package study.calculator

class DefaultParser : Parser<String, List<Int>> {
    override fun parse(source: String): List<Int> {
        return parseNumbers(source)
    }

    private fun extractCustomDelimiter(text: String): String? {
        val matchResult = CUSTOM_DELIMITER_EXTRACT_PATTERN.find(text)
        return matchResult?.groups?.get(1)?.value
    }

    private fun parseNumbers(text: String): List<Int> {
        val customDelimiter = extractCustomDelimiter(text)
        val numbersText = removeCustomDelimiterPattern(text)
        return splitUsingDelimiter(numbersText, customDelimiter).let(::convertToInt)
    }

    private fun removeCustomDelimiterPattern(text: String): String {
        return text.replace(CUSTOM_DELIMITER_REMOVE_PATTERN, "")
    }

    private fun splitUsingDelimiter(text: String, delimiter: String? = null): List<String> {
        val regexPattern = buildDelimiterPattern(delimiter)
        return text.split(regexPattern)
    }

    private fun buildDelimiterPattern(delimiter: String?): Regex {
        val customDelimiterPattern = delimiter?.let { Regex.escape(it) }?.let { "|$it" } ?: ""
        return Regex("(${DEFAULT_DELIMITERS}$customDelimiterPattern)|$NEW_LINE")
    }

    private fun convertToInt(numbers: List<String>): List<Int> {
        return numbers.map { numStr ->
            numStr.toIntOrNull() ?: throw RuntimeException("Invalid input: $numStr")
        }
    }

    private companion object {
        const val NEW_LINE = "\\n"
        const val DEFAULT_DELIMITERS = ",|:"
        const val CUSTOM_DELIMITER_PREFIX = "//"
        val CUSTOM_DELIMITER_REMOVE_PATTERN = Regex("^$CUSTOM_DELIMITER_PREFIX.*?$NEW_LINE")
        val CUSTOM_DELIMITER_EXTRACT_PATTERN = Regex("^$CUSTOM_DELIMITER_PREFIX(.+?)$NEW_LINE")
    }
}
