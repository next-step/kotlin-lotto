package calculator

object DelimiterExtractor {
    private const val DELIMITER_EXTRACT_PATTERN = "//(.)\n(.*)"

    fun extractDelimiterAndText(text: String): CustomDelimiter {
        val matchResult = Regex(DELIMITER_EXTRACT_PATTERN).find(text)

        val delimiter = matchResult?.groupValues?.getOrNull(1)
        val resultText = matchResult?.groupValues?.getOrNull(2) ?: text

        return CustomDelimiter(delimiter, resultText)
    }
}
