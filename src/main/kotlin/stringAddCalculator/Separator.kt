package stringAddCalculator

object Separator {
    private const val BASIC_DELIMITER_PATTERN = "[,:]"
    private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"

    fun separate(text: String): List<String> {
        return text.split(BASIC_DELIMITER_PATTERN.toRegex())
    }

    fun separateByCustomDelimiter(text: String): List<String>? {
        val matchResult = Regex(CUSTOM_DELIMITER_PATTERN).find(text)
        return matchResult?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        }
    }
}