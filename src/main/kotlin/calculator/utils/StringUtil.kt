package calculator.utils

object StringUtil {
    private val BASIC_PATTERN = Regex(",|:")
    private val CUSTOM_PATTERN = Regex("//(.)\n(.*)")

    fun convertTexts(text: String): List<String> {
        val matchResult = CUSTOM_PATTERN.find(text)
        return if (matchResult != null) {
            splitTextFromCustomPattern(matchResult)
        } else {
            text.split(BASIC_PATTERN)
        }
    }
    private fun splitTextFromCustomPattern(it: MatchResult): List<String> {
        val (customDelimiter, matchingText) = it.destructured
        return matchingText.split(customDelimiter)
    }
}
