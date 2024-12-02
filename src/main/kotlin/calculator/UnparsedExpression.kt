package calculator

class UnparsedExpression(
    private val input: String?,
) {
    val text: String
        get() = input?.takeIf { it.isNotBlank() } ?: "0"

    fun splitText(): TextTokens {
        val customTokens = splitByCustomDelimiter(text)
        val allTokens =
            customTokens.flatMap { token ->
                token.split(DEFAULT_DELIMITER.toRegex())
            }
        return addTextTokens(allTokens.filter { it.isNotBlank() }.distinct())
    }

    private fun addTextTokens(textTokens: List<String>): TextTokens {
        val numbers = textTokens.map { PositiveNumber.of(it) }
        return TextTokens(numbers)
    }

    private fun splitByCustomDelimiter(text: String): List<String> {
        val matchResult = Regex(CUSTOM_DELIMITER).find(text)
        return matchResult?.let {
            val customDelimiter = it.groupValues[1]
            val customText = it.groupValues[2]
            customText.split(customDelimiter)
        } ?: listOf(text)
    }

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
