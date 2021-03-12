package stringcalculator.domain

object StringAddCalculator {
    fun calculate(tokens: Tokens): Int = tokens.tokens.sumBy { it.value }
}
