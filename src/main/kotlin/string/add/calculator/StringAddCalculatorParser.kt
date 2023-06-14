package string.add.calculator

class StringAddCalculatorParser {
    private val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

    fun parseText(text: String): List<String> {
        var textAfterCustomDelimiter = text

        findCustomDelimiter(text)?.let {
            delimiters.add(it)
            textAfterCustomDelimiter = text.substringAfter(CUSTOM_DELIMITER_END)
        }

        return textAfterCustomDelimiter.split(*delimiters.toTypedArray())
    }

    private fun findCustomDelimiter(text: String): String? {
        val result = Regex("//(.)\n(.*)").find(text)
        return result?.groupValues?.get(1)
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA: String = ","
        private const val DEFAULT_DELIMITER_COLON: String = ":"
        private const val CUSTOM_DELIMITER_END: String = "\n"
    }
}