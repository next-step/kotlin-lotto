package calculator.domain

class StringSplit(
    private val input: String
) {

    fun splitString(): List<String> {
        return splitCustomDelimiter(input) ?: splitDelimeter(input)
    }

    private fun splitDelimeter(input: String): List<String> {
        return input.split(DEFAULT_DELIMITER_REGEX)
    }

    private fun splitCustomDelimiter(input: String): List<String>? {
        val result = CUSTOM_DELIMITER_REGEX.find(input) ?: return null
        val delimiter = result.groupValues[1]
        val splitStringList = result.groupValues[2]
        return splitStringList.split(delimiter)
    }

    companion object {
        private const val COMMA_DELIMITER = ","
        private const val COLON_DELIMITER = ":"

        private val DEFAULT_DELIMITER_REGEX = Regex("$COLON_DELIMITER|$COMMA_DELIMITER")
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    }
}
