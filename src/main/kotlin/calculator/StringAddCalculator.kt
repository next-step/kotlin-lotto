package calculator

class StringAddCalculator(
    private val parser: ExpressionParser
) {
    fun add(text: String?): Int {
        val expression: List<PositiveInteger> = parser.parse(text)
        return calculate(expression)
    }

    private fun calculate(expression: List<PositiveInteger>): Int {
        return expression.sumOf { it.value }
    }
}