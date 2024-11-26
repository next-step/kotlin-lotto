package calculator

class UnparsedExpression(
    var text: String? = null,
) {
    init {
        if (text.isNullOrEmpty() || text.isNullOrBlank()) {
            text = "0"
        }
    }

    fun splitText(): TextTokens {
        val value = requireNotNull(text) { "입력값을 확인하세요" }
        val textTokens = splitByCustomDelimiter()
        if (textTokens.isNotEmpty()) {
            return addTextTokens(textTokens)
        }
        val tokens = value.split(DEFAULT_DELIMITER.toRegex())
        return addTextTokens(tokens)
    }

    private fun addTextTokens(textTokens: List<String>): TextTokens {
        val tokens = TextTokens()
        for (text in textTokens) {
            tokens.addToken(text)
        }
        return tokens
    }

    private fun splitByCustomDelimiter(): List<String> {
        val result = text?.let { Regex(CUSTOM_DELIMITER).find(it) }
        result?.let {
            val customDelimiter = it.groupValues[1]
            return it.groupValues[2].split(customDelimiter)
        }
        return emptyList()
    }

    companion object {
        private const val DEFAULT_DELIMITER = ",|:"
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
