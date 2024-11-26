package calculator

class UnparsedExpression(
    var text: String,
) {
    init {
        if (text.isNullOrEmpty() || text.isNullOrBlank()) {
            text = "0"
        }
    }

    fun split(): TextTokens {
        val textTokens = text.split(",|:".toRegex())
        val tokens = TextTokens()
        for (text in textTokens) {
            tokens.addToken(text)
        }
        return tokens
    }
}
