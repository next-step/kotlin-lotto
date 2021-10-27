package domain.calculator.domain.separator

import domain.calculator.domain.expression.Expression
import domain.calculator.domain.separator.Separator.Companion.DEFAULT_SEPARATOR_COLON
import domain.calculator.domain.separator.Separator.Companion.DEFAULT_SEPARATOR_COMMA
import domain.calculator.strategy.RegexStrategy

@JvmInline
value class Separators private constructor(private val separators: Set<Separator>) {
    init {
        if (separators.isEmpty()) throw RuntimeException(EMPTY_SET_EXCEPTION_MESSAGE)
    }

    companion object {
        private const val EMPTY_SET_EXCEPTION_MESSAGE = "Separators, 비어있는 컬렉션은 입력될 수 없습니다."

        fun of(separators: Set<Separator>): Separators = Separators(separators.toSet())
        fun of(expression: String, regexStrategy: RegexStrategy): Separators = of(Expression(expression, regexStrategy))
        fun of(expression: Expression): Separators =
            when (expression.hasCustomExpression()) {
                true -> Separators(customSeparators(expression))
                false -> Separators(defaultSeparators())
            }

        private fun defaultSeparators(): Set<Separator> =
            setOf(
                Separator(DEFAULT_SEPARATOR_COMMA),
                Separator(DEFAULT_SEPARATOR_COLON)
            )

        private fun customSeparators(expression: Expression): Set<Separator> =
            setOf(
                Separator(expression.customExpression())
            )
    }
}
