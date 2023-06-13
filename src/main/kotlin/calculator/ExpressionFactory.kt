package calculator

interface ExpressionFactory {
    fun createExpression(input: String?): Expression
}
