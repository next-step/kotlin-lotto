package stringcalculator

import stringcalculator.util.StringExpressionParser.splitByCustomDelimiter
import stringcalculator.util.StringExpressionParser.splitByDefaultDelimiter
import stringcalculator.util.StringExpressionParser.toOneDigitNaturalNumber

class StringAddCalculator {
    @Throws(RuntimeException::class)
    fun add(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return DEFAULT_VALUE
        }

        val numbersByCustomDelimiter = expression.splitByCustomDelimiter()
        if (numbersByCustomDelimiter.isNotEmpty()) {
            return numbersByCustomDelimiter.sumOf {
                it.toOneDigitNaturalNumber()
            }
        }

        return expression.splitByDefaultDelimiter()
            .sumOf {
                it.toOneDigitNaturalNumber()
            }
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}
