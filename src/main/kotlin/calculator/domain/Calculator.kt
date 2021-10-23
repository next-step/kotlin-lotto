package calculator.domain

class Calculator(
    private val expression: Expression,
) {
    fun calculate(): Int {
        return expression.prepareCalculation()
            .sumOf { it.toInt() }
    }
}
