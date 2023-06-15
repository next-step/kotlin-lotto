package calculator.domain

object Tokenizer {
    private val DEFAULT_SEPARATORS = "[,:]".toRegex()
    private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\n(.*)")

    fun getTokens(input: String): List<String> {
        val result = CUSTOM_DELIMITER_PATTERN.find(input)
            ?: return input.split(DEFAULT_SEPARATORS)
        val customDelimiter = result.groupValues[1]

        require(customDelimiter.isNotEmpty()) { "커스텀 구분자가 비어있습니다." }

        return result.groupValues[2].split(customDelimiter)
    }
}
