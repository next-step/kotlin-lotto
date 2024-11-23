package calculator

import calculator.Patterns.DEFAULT

object DefaultExpressionCreator : ExpressionCreator {
    override fun create(expression: String): Expressions {
        return Expressions.created(expression, DEFAULT.regex)
    }
}