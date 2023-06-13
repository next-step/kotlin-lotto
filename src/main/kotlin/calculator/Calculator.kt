package calculator

class Calculator {
    private val parser: ExpressionParser = ExpressionParser()
    fun calculate(expression: String): Int = parser.parse(expression).sum()
}
