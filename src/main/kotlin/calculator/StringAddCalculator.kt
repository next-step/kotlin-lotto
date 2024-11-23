package calculator

object StringAddCalculator {
    fun calculate(expression: String): Int {
        return Expression(expression).sum()
    }
}
