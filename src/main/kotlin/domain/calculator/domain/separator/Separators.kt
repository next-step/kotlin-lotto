package domain.calculator.domain.separator

import domain.calculator.domain.expression.Expression
import domain.calculator.domain.separator.Separator.Companion.DEFAULT_SEPARATOR_COLON
import domain.calculator.domain.separator.Separator.Companion.DEFAULT_SEPARATOR_COMMA
import domain.calculator.strategy.RegexStrategy

@JvmInline
value class Separators private constructor(private val _separators: Set<Separator>) {
    val separators: String
        get() = _separators
            .map(Separator::separator)
            .joinToString(REGEX_SEPARATOR)

    companion object {
        private const val EMPTY_EXCEPTION_MESSAGE = "Separators, 비어있는 컬렉션은 입력될 수 없습니다."
        private const val REGEX_SEPARATOR = "|"

        fun of(expression: String, regexStrategy: RegexStrategy): Separators = of(Expression(expression, regexStrategy))
        fun of(expression: Expression): Separators =
            if (expression.hasCustomExpression()) Separators(customSeparators(expression))
            else Separators(defaultSeparators())

        fun of(separators: Set<Separator>): Separators =
            if (separators.isEmpty()) throw RuntimeException(EMPTY_EXCEPTION_MESSAGE)
            else Separators(separators.toSet())

        private fun customSeparators(expression: Expression): Set<Separator> =
            setOf(Separator(expression.customSeparatorExpression()))

        private fun defaultSeparators(): Set<Separator> =
            setOf(
                Separator(DEFAULT_SEPARATOR_COMMA),
                Separator(DEFAULT_SEPARATOR_COLON)
            )
    }
}
