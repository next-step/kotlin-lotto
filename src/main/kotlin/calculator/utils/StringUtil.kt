package calculator.utils

object StringUtil {
    private val basicPattern = Regex(",|:")
    private val customPattern = Regex("//(.)\n(.*)")

    fun convertTextToList(text: String): List<String> =
        customPattern.find(text)?.let {
            splitTextFromCustomPattern(it)
        } ?: text.split(basicPattern)

    private fun splitTextFromCustomPattern(it: MatchResult): List<String> {
        val (customDelimiter, matchingText) = it.destructured
        return matchingText.split(customDelimiter)
    }
}
