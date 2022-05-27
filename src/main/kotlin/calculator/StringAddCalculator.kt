package calculator

import calculator.number.PositiveNumber
import calculator.splitter.Splitters

object StringAddCalculator {
    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) return 0

        return Splitters.tokenize(expression)
            .getSumOfStrings()
    }
    private fun List<String>.getSumOfStrings() = sumOf { PositiveNumber(it).value }
}
