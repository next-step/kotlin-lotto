package calculator

import calculator.Patterns.NONE

object NoneExpressionCreator : ExpressionCreator {
    override fun create(expression: String): Expressions {
        return Expressions.created(expression, NONE.regex)
    }
}
