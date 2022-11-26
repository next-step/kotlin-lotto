package calculator

object OperandExtractor {

    private val DEFAULT_DELIMITER = Regex("[,:]")
    private val CUSTOM_DELIMITER_SPECIFIER = Regex("//(.)\n(.*)")

    fun extractOperand(text: String?): List<Int> = if (text.isNullOrBlank()) {
        listOf(0)
    } else {
        extractDelimiter(text).map { char ->
            char.toInt()
        }
    }

    private fun extractDelimiter(text: String): List<String> {
        return CUSTOM_DELIMITER_SPECIFIER.find(text)
            ?.let {
                val customDelimiter = it.groupValues[1]
                it.groupValues[2].split(customDelimiter)
            }
            ?: text.split(DEFAULT_DELIMITER)
    }
}