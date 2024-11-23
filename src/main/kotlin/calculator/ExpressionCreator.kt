package calculator

interface ExpressionCreator {
    fun create(expression: String): Expressions
}
