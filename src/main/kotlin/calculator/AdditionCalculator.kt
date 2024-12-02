package calculator

object AdditionCalculator {
    fun calculate(unparsedExpression: UnparsedExpression): Int {
        val textTokens = unparsedExpression.splitText()
        return textTokens.sum()
    }
}
