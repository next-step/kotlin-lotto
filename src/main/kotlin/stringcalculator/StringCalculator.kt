package stringcalculator

class StringCalculator {
    fun sum(exp: String): Int {
        val rawTokens = TokenSplitter.splitExpBySeparator(exp)
        val convertedTokens = convertTokens(rawTokens)
        return sumTokens(convertedTokens)
    }

    private fun convertTokens(tokens: List<String>): List<StringToken> {
        return tokens.map { t -> StringToken(t) }.toList()
    }

    private fun sumTokens(tokens: List<StringToken>): Int {
        return tokens.sumOf { stringToken -> stringToken.getIntValue }
    }
}
