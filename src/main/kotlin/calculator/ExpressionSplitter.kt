package calculator

object ExpressionSplitter {
    private const val DELIMITER_COMMA = ","
    private const val DELIMITER_COLON = ":"

    fun split(text: String): List<String> {
        val (customDelimiter, extractedText) = DelimiterExtractor.extractDelimiterAndText(text)
        val delimiters = arrayOf(DELIMITER_COMMA, DELIMITER_COLON, customDelimiter).filterNotNull()
        val regex = DelimiterManager.generateRegex(delimiters)
        return extractedText.split(regex)
    }
}
