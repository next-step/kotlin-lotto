package stringcalculator.domain

class StringAddCalculator {

    companion object {
        fun calculate(tokens: Tokens): Int = tokens.tokens.sumBy { it.value }
    }
}
