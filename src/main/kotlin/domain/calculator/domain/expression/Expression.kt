package domain.calculator.domain.expression

import domain.calculator.domain.PositiveOperand
import domain.calculator.strategy.RegexStrategy

data class Expression(private val _expression: String?, private val regexStrategy: RegexStrategy) {
    private val rawExpression: String = if (_expression.isNullOrBlank()) DEFAULT_STRING else _expression

    fun customSeparatorExpression(): String {
        return when (hasCustomExpression()) {
            true -> regexStrategy.groupValue(rawExpression, CUSTOM_SEPARATOR)
            else -> throw RuntimeException()
        }
    }

    fun calculateExpression(): String {
        return when (hasCustomExpression()) {
            true -> regexStrategy.groupValue(rawExpression, NUMBER_EXPRESSION)
            else -> rawExpression
        }
    }

    fun hasCustomExpression(): Boolean = regexStrategy.check(rawExpression)

    fun split(delimiters: String): List<PositiveOperand> =
        calculateExpression().split(Regex(delimiters))
            .asSequence()
            .map(PositiveOperand::of)
            .toList()

    companion object {
        private const val DEFAULT_STRING = "0"

        private const val CUSTOM_SEPARATOR = 1
        private const val NUMBER_EXPRESSION = 2
    }
}
