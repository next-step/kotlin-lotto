package calculator

object NumbersExtractor {

    private val DEFAULT_DELIMITER = Regex("[,:]")
    private val CUSTOM_DELIMITER_SPECIFIER = Regex("//(.)\n(.*)")

    fun run(text: String?): List<Number> = if (text.isNullOrBlank()) {
        listOf(Number.zero())
    } else {
        extractNumber(text)
    }

    private fun extractNumber(text: String): List<Number> = removeDelimiter(text).map { char ->
        Number.of(char)
    }

    private fun removeDelimiter(text: String): List<String> {
        return CUSTOM_DELIMITER_SPECIFIER.find(text)
            ?.let {
                val customDelimiter = it.groupValues[1]
                it.groupValues[2].split(customDelimiter)
            }
            ?: text.split(DEFAULT_DELIMITER)
    }
}