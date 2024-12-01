package calculator

object DelimiterExtractor {
    private const val DELIMITER_EXTRACT_PATTERN = "//(.)\n(.*)"
    private const val EXTRACTED_DELIMITER_INDEX = 1
    private const val EXTRACTED_TEXT_INDEX = 2

    fun extractDelimiterAndText(text: String): CustomDelimiter {
        val matchResult = Regex(DELIMITER_EXTRACT_PATTERN).find(text)

        val delimiter = matchResult?.groupValues?.getOrNull(EXTRACTED_DELIMITER_INDEX)
        val resultText = matchResult?.groupValues?.getOrNull(EXTRACTED_TEXT_INDEX) ?: text

        return CustomDelimiter(delimiter, resultText)
    }
}
