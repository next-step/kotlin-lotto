package stringAddCalculator

object StringSeparator {
    private val BASIC_DELIMITER_PATTERN = Regex("[,:]")
    private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")

    fun separate(text: String): Tokens {
        val customMatchResult = CUSTOM_DELIMITER_PATTERN.find(text)
        val values = customMatchResult?.let {
            val customDelimiter = it.groupValues[1]
            it.groupValues[2].split(customDelimiter)
        } ?: text.split(BASIC_DELIMITER_PATTERN)
        return Tokens(values.map { Token.of(it) })
    }
}
