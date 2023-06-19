package stringcalculator

class Delimiters {
    private val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

    fun addDelimiter(delimiter: String) {
        delimiters.add(delimiter)
    }

    fun getDelimitersRegex(): Regex {
        return delimiters.joinToString("", "[", "]").toRegex()
    }

    companion object {
        const val DEFAULT_DELIMITER_COMMA = ","
        const val DEFAULT_DELIMITER_COLON = ":"
        const val CUSTOM_DELIMITER_FIND_REGEX = "//(.)\n(.*)"
    }
}
