package calculator

import calculator.Patterns.CUSTOM_DELIMITER

object ExpressionFactory {
    fun determine(expression: String): Expressions {
        return when {
            expression.isBlank() -> NoneExpressionCreator.create(expression)
            CUSTOM_DELIMITER.hasMatch(expression) -> CustomExpressionCreator.create(expression)
            else -> DefaultExpressionCreator.create(expression)
        }
    }
}
