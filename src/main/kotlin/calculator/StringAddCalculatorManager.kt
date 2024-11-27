package calculator

class StringAddCalculatorManager {
    fun start(input: String?): Int {
        val parsedNumbers = inputToListOrThrow(input)
        return StringAddCalculator(parsedNumbers).calculate()
    }

    fun inputToListOrThrow(input: String?): List<Int> {
        if (input.isNullOrBlank()) return emptyList()
        val parsedNumbers = split(input)
        parsedNumbers.apply { if (any { it < 0 }) throw RuntimeException() }
        return parsedNumbers
    }

    private fun split(input: String): List<Int> {
        val customDelimiter = getCustomDelimiter(input)
        val deletedCustomDelimiter = deleteCustomDelimiter(input)
        val regex = buildRegex(customDelimiter)

        return deletedCustomDelimiter.split(regex)
            .map { it.toInt() }
    }

    private fun buildRegex(customDelimiter: String): Regex {
        val delimiters = listOf(DELIMITER_COMMA, DELIMITER_COLON, customDelimiter)
        val escapedDelimiters =
            delimiters
                .filter { it.isNotEmpty() }
                .joinToString(DELIMITER_SEPARATOR) { Regex.escape(it) }
        return Regex(escapedDelimiters)
    }

    private fun getCustomDelimiter(input: String?): String =
        input?.takeIf { it.startsWith(CUSTOM_DELIMITER_PREFIX) && it.contains(CUSTOM_DELIMITER_SUFFIX) }
            ?.substringAfter(CUSTOM_DELIMITER_PREFIX)?.substringBefore(CUSTOM_DELIMITER_SUFFIX) ?: ""

    private fun deleteCustomDelimiter(input: String?): String {
        if (input.isNullOrBlank()) return ""

        val regex = Regex("${Regex.escape(CUSTOM_DELIMITER_PREFIX)}.*?${Regex.escape(CUSTOM_DELIMITER_SUFFIX)}")
        return input.replace(regex, "").trim()
    }

    companion object {
        private const val DELIMITER_COMMA = ","
        private const val DELIMITER_COLON = ":"
        private const val DELIMITER_SEPARATOR = "|"
        private const val CUSTOM_DELIMITER_PREFIX = "//"
        private const val CUSTOM_DELIMITER_SUFFIX = "₩n"
    }
}
