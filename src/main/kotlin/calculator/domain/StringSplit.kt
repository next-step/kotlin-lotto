package calculator.domain

class StringSplit(
    private val input: String
) {

    fun splitString(): List<String> {
        val isMatcher = CUSTOM_DELIMITER_REGEX.matches(input)
        return if (isMatcher) splitCustomDelimiter(input) else splitDelimiter(input)
    }

    private fun splitDelimiter(input: String): List<String> {
        return input.split(DEFAULT_DELIMITER_REGEX)
    }

    private fun splitCustomDelimiter(input: String): List<String> {
        val result = CUSTOM_DELIMITER_REGEX.matchEntire(input)!!
        return result.groupValues[2].split(result.groupValues[1])
    }

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"

        private val DEFAULT_DELIMITER_REGEX = Regex("$COLON_DELIMITER|$COMMA_DELIMITER")
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    }
}
