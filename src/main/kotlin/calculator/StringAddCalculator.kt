package calculator

import calculator.number.PositiveNumber
import calculator.splitter.CustomDelimiterSplitter
import calculator.splitter.DefaultDelimiterSplitter

object StringAddCalculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0

        return expression
            .splitToStringTokens()
            .getSumOfStrings()
    }

    private fun String.splitToStringTokens() = when {
        CustomDelimiterSplitter.isApplicable(this) -> CustomDelimiterSplitter.trySplit(this)
        DefaultDelimiterSplitter.isApplicable(this) -> DefaultDelimiterSplitter.trySplit(this)
        else -> throw IllegalArgumentException("알맞은 수식어가 아닙니다.")
    }

    private fun List<String>.getSumOfStrings() = sumOf { PositiveNumber(it).value }
}
