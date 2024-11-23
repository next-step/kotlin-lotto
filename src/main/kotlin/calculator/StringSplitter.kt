package calculator

object StringSplitter {
    private const val DELIMITER_COMMA = ","
    private const val DELIMITER_COLON = ":"

    fun splitByCommaAndColon(text: String): List<String> {
        val delimiters = DelimiterRegexGenerator.generate(DELIMITER_COMMA, DELIMITER_COLON)
        return text.split(delimiters)
    }
}
