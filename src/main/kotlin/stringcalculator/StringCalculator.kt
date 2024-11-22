package stringcalculator

class StringCalculator {
    fun sum(exp: String): Int {
        val tokens = TokenSplitter.splitExpBySeparator(exp)
        return sumTokens(tokens)
    }

    private fun sumTokens(tokens: List<String>): Int {
        return tokens.sumOf { token ->
            token.toIntOrNull()?.takeIf { isPositiveInt(it) } ?: throw RuntimeException()
        }
    }

    private fun isPositiveInt(it: Int) = it >= 0
}
