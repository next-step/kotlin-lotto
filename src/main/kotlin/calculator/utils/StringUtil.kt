package calculator.utils

object StringUtil {
    private val BASIC_PATTERN = Regex(",|:")
    private val CUSTOM_PATTERN = Regex("//(.)\n(.*)")

    fun convertTextToList(text: String): List<String> =
        CUSTOM_PATTERN.find(text)?.let {
            val (customDelimiter, matchingText) = it.destructured
            matchingText.split(customDelimiter)
        } ?: text.split(BASIC_PATTERN)
}
