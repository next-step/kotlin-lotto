package calculator.utils

private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"

object CustomDelimiterExtractor {
    private val regex = Regex(CUSTOM_DELIMITER_PATTERN)
    fun extract(text: String): Pair<String, String> {
        val matchResult = regex.find(text)
        val extractedDelimiter = matchResult?.groupValues?.getOrNull(1) ?: ""
        val extractedText = matchResult?.groupValues?.getOrNull(2) ?: text
        return extractedDelimiter to extractedText
    }
}
