package stringaddcalculator.domain

object DelimiterFinder {
    private val BASIC_DELIMITERS = listOf(",", ":")
    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")

    fun find(string: String): List<String> {
        if (string.hasCustomDelimiter()) {
            return BASIC_DELIMITERS + findCustomDelimiter(string)
        }
        return BASIC_DELIMITERS
    }

    private fun String.hasCustomDelimiter(): Boolean {
        return CUSTOM_DELIMITER_REGEX.matches(this)
    }

    private fun findCustomDelimiter(inputString: String): String {
        return CUSTOM_DELIMITER_REGEX.find(inputString)?.groupValues?.getOrNull(1)
            ?: throw IllegalArgumentException("$inputString 는 유효하지 않은 문자열입니다.")
    }
}
