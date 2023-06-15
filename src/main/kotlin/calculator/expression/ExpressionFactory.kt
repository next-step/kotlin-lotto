package calculator.expression

class ExpressionFactory {
    companion object {
        fun createExpression(input: String?): Expression {
            return Expression(input)
        }
    }
}
