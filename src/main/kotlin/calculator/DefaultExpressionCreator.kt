package calculator

import calculator.Patterns.DEFAULT_DELIMITER

object DefaultExpressionCreator : ExpressionCreator {
    override fun create(expression: String): Expressions {
        return Expressions.created(expression, DEFAULT_DELIMITER.regex)
    }
}
