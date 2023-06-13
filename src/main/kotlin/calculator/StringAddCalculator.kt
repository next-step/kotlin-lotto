package calculator

class StringAddCalculator(
    private val expressionFactory: ExpressionFactory
) {
    fun add(input: String?): Int {
        val expression = expressionFactory.createExpression(input)
        return expression.numbers.sum()
    }
}
