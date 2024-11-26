package calculator

object AdditionCalculator {
    fun calculate(tokens: TextTokens): Int {
        return tokens.sum()
    }
}
