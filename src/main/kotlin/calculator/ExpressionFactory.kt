package calculator

import calculator.Patterns.CUSTOM

object ExpressionFactory {
    fun determine(expression: String): Expressions {
        return when {
            expression.isBlank() -> NoneExpressionCreator.create(expression)
            CUSTOM.hasMatch(expression) -> CustomExpressionCreator.create(expression)
            else -> DefaultExpressionCreator.create(expression)
        }
    }
}
