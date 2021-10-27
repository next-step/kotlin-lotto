package domain.calculator.domain.expression

import domain.calculator.strategy.RegexStrategy

data class Expression(private val _expression: String?, private val regexStrategy: RegexStrategy) {
    private val expression: String = if (_expression.isNullOrBlank()) DEFAULT_STRING else _expression

    fun customExpression(): String {
        return when (hasCustomExpression()) {
            true -> regexStrategy.groupValue(expression, CUSTOM_SEPARATOR)
            else -> throw RuntimeException()
        }
    }

    fun calculationExpression(): String {
        return when (hasCustomExpression()) {
            true -> regexStrategy.groupValue(expression, NUMBER_EXPRESSION)
            else -> expression
        }
    }

    fun hasCustomExpression(): Boolean = regexStrategy.check(expression)

    companion object {
        private const val DEFAULT_STRING = "0"

        private const val CUSTOM_SEPARATOR = 1
        private const val NUMBER_EXPRESSION = 2
    }
}
