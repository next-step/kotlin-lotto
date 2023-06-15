package calculator

class ExpressionFactory {
    companion object {
        fun createExpression(input: String?): Expression {
            return Expression(input)
        }
    }
}
