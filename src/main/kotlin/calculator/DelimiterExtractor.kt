package calculator

object DelimiterExtractor {
    private val DEFAULT_DELIMITER_REGEX = "[,:]".toRegex()
    private val CUSTOM_DELIMITER_EXTRACT_REGEX = Regex("//(.)\n(.*)")

    fun extractNumbers(input: String): List<PositiveNumber> {
        require(input.isNotEmpty()) { "입력 값이 비어있을 수는 없어요." }

        val tokens = extractTokens(input)
        return tokens.map { token -> PositiveNumber.of(token) }
    }

    private fun extractTokens(input: String): List<String> {
        val result = CUSTOM_DELIMITER_EXTRACT_REGEX.find(input)
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }

        return input.split(DEFAULT_DELIMITER_REGEX)
    }

}
