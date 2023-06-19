package stringcalculator

class Delimiters {
    private val delimiters = mutableListOf(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)

    private fun addDelimiter(delimiter: String) {
        delimiters.add(delimiter)
    }

    fun getDelimitersRegex(): Regex {
        return delimiters.joinToString("", "[", "]").toRegex()
    }

    fun checkCustomDelimiter(text: String) {
        val result = Regex(CUSTOM_DELIMITER_FIND_REGEX).find(text)
        result?.let {
            addDelimiter(it.groupValues[CUSTOM_DELIMITER_EXIST_INDEX])
        }
    }

    companion object {
        const val DEFAULT_DELIMITER_COMMA = ","
        const val DEFAULT_DELIMITER_COLON = ":"
        const val CUSTOM_DELIMITER_EXIST_INDEX = 1
        const val CUSTOM_DELIMITER_FIND_REGEX = "//(.)\n(.*)"
    }
}