package calculator

object AdditionCalculator {
    fun calculate(tokens: TextTokens): Int {
        return tokens.sum()
    }

    fun calculate(unparsedExpression: UnparsedExpression): Int {
        val textTokens = unparsedExpression.splitText()
        return textTokens.sum()
    }
}
