package calculator

class DelimiterParser(private val text: String) {
    fun extractNumbers(): List<String> {
        return if (isCustomDelimiter()) {
            val remainderText = text.substringAfter(CUSTOM_END_WITH_MARKER)
            val customDelimiter = parseCustomDelimiter()

            remainderText.split(customDelimiter)
        } else {
            text.split(COMMA_DELIMITER, COLON_DELIMITER)
        }
    }

    private fun isCustomDelimiter(): Boolean {
        return text.startsWith(CUSTOM_START_WITH_MARKER)
    }

    private fun parseCustomDelimiter(): String {
        return text.substringAfter(CUSTOM_START_WITH_MARKER).substringBefore(CUSTOM_END_WITH_MARKER)
    }

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"
        private const val CUSTOM_START_WITH_MARKER = "//"
        private const val CUSTOM_END_WITH_MARKER = "\n"
    }
}
