package domain.calculator.domain.expression

import domain.calculator.domain.operand.PositiveOperand
import domain.calculator.strategy.RegexStrategy

data class Expression(private val expression: String = DEFAULT_STRING, private val regexStrategy: RegexStrategy) {

    fun customSeparatorExpression(): String {
        if (hasCustomExpression()) {
            return regexStrategy.groupValue(expression, CUSTOM_SEPARATOR)
        }
        throw RuntimeException(NO_EXIST_CUSTOM_SEPARATOR_EXCEPTION_MESSAGE)
    }

    fun calculateExpression(): String {
        if (hasCustomExpression()) {
            return regexStrategy.groupValue(expression, NUMBER_EXPRESSION)
        }
        return expression
    }

    fun hasCustomExpression(): Boolean = regexStrategy.check(expression)

    fun split(delimiters: String): List<PositiveOperand> =
        calculateExpression().split(Regex(delimiters))
            .asSequence()
            .map(::PositiveOperand)
            .toList()

    companion object {
        private const val DEFAULT_STRING = "0"
        private const val NO_EXIST_CUSTOM_SEPARATOR_EXCEPTION_MESSAGE = "현재 표현식에는 커스텀 구분자 없습니다."

        private const val CUSTOM_SEPARATOR = 1
        private const val NUMBER_EXPRESSION = 2
    }
}
