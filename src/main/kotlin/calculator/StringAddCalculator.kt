package calculator

class StringAddCalculator(
    private val expression: Expression
) {
    fun add(): Int {
        return expression.numbers.sum()
    }
}
