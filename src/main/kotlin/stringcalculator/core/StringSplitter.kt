package stringcalculator.core

class StringSplitter(private val token: String, private val customDelimiter: String = "") {
    fun split(): List<String> {
        return token.split(Regex(makeDelimiterRegex()))
    }

    private fun makeDelimiterRegex(): String {
        return listOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_SEMICOLON, customDelimiter)
            .joinToString(DELIMITER_SEPARATOR, DELIMITER_PREFIX, DELIMITER_POSTFIX)
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_SEMICOLON = ";"

        private const val DELIMITER_PREFIX = "["
        private const val DELIMITER_POSTFIX = "]"

        private const val DELIMITER_SEPARATOR = ""
    }
}
