package stringaddcalculator

object StringSeparator {
    private const val BASIC_DELIMITER_COMMA = ","
    private const val BASIC_DELIMITER_COLON = ":"

    fun separate(inputString: String): List<String> {
        return inputString.split(BASIC_DELIMITER_COMMA, BASIC_DELIMITER_COLON)
    }

    private fun findCustomDelimiter(inputString: String) {
    }
}
