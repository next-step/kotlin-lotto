package calculator

class Parser(private var delimiters: HashSet<String> = DEFAULT_DELIMITER) {
    fun parseNumbers(text: String?): List<Int> {
        if (text.isNullOrBlank()) {
            return listOf(DEFAULT_VALUE)
        }
        val (delimiterText, numberText) = extractDelimiterAndNumber(text)
        addDelimiter(delimiterText)
        return extractNumber(numberText)
    }

    private fun extractNumber(text: String): List<Int> =
        text.split(
            delimiters.joinToString(separator = REGULAR_EXPRESSION_OR).toRegex()
        ).map { it.toInt() }

    private fun extractDelimiterAndNumber(text: String): DelimiterAndNumber =
        REGULAR_EXPRESSION_CUSTOM_DELIMITER.toRegex().find(text)?.let {
            DelimiterAndNumber(delimiterText = it.groupValues[1], numberText = it.groupValues[2])
        } ?: DelimiterAndNumber(numberText = text)

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
