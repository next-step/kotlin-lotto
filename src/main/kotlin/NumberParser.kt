class NumberParser(private var delimiters: HashSet<String> = DEFAULT_DELIMITER) {
    fun parseNumbers(text: String?): List<Int> =
        if (text.isNullOrBlank()) {
            listOf(DEFAULT_VALUE)
        } else {
            val (customDelimiter, newText) = extractDelimiter(text)
            addDelimiter(customDelimiter)
            extractNumber(newText)
        }

    private fun extractNumber(text: String): List<Int> =
        text.split(
            delimiters.joinToString(separator = REGULAR_EXPRESSION_OR).toRegex()
        ).map { it.toInt() }

    private fun extractDelimiter(text: String): Pair<String, String> =
        REGULAR_EXPRESSION_CUSTOM_DELIMITER.toRegex().find(text)?.let {
            Pair(it.groupValues[1], it.groupValues[2])
        } ?: Pair("", text)

    private fun addDelimiter(delimiter: String?) {
        if (!delimiter.isNullOrBlank()) {
            delimiters.add(delimiter)
        }
    }

    companion object {
        private val DEFAULT_DELIMITER = hashSetOf(",", ":")
        private const val DEFAULT_VALUE = 0
        private const val REGULAR_EXPRESSION_OR = "|"
        private const val REGULAR_EXPRESSION_CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
