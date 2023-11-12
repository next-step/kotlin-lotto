package stringAddCalculator

object StringSeparator {
    private val BASIC_DELIMITER_PATTERN = Regex("[,:]")
    private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")

    fun separate(text: String): List<String> {
        return text.split(BASIC_DELIMITER_PATTERN)
    }

    fun separateByCustomDelimiter(text: String): List<String>? {
        val matchResult = CUSTOM_DELIMITER_PATTERN.find(text)
        return matchResult?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        }
    }
}
