package calculator

object Calculator {
    fun calculate(expression: String): Int = ExpressionParser.parse(expression).sum()
}
