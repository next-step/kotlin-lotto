package calculator

class DefaultExpressionFactory : ExpressionFactory {
    override fun createExpression(input: String?): Expression {
        return Expression(input)
    }
}
