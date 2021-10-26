package domain.calculator.domain.separator

import domain.calculator.domain.expression.Expression
import domain.calculator.domain.separator.Separator.Companion.DEFAULT_SEPARATOR_COLON
import domain.calculator.domain.separator.Separator.Companion.DEFAULT_SEPARATOR_COMMA

@JvmInline
value class Separators private constructor(private val separators: Set<Separator>) {

    companion object {
        fun of(separators: Set<Separator>): Separators = Separators(separators.toSet())
        fun of(expression: String): Separators = of(Expression(expression))
        fun of(expression: Expression): Separators =
            when (expression.hasCustomExpression()) {
                true -> Separators(defaultSeparators() + Separator(expression.customSeparator))
                false -> Separators(defaultSeparators())
            }

        private fun defaultSeparators(): Set<Separator> =
            setOf(
                Separator(DEFAULT_SEPARATOR_COMMA),
                Separator(DEFAULT_SEPARATOR_COLON)
            )
    }
}
