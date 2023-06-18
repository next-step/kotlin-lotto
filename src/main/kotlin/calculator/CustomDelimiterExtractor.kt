package calculator

private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"

object CustomDelimiterExtractor {
    fun extract(text: String): Pair<String, String> {
        val regex = Regex(CUSTOM_DELIMITER_PATTERN)
        val matchResult = regex.find(text)
        val extractedDelimiter = matchResult?.groupValues?.getOrNull(1) ?: ""
        val extractedText = matchResult?.groupValues?.getOrNull(2) ?: text
        return extractedDelimiter to extractedText
    }
}
