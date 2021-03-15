package calculator

class StringAdditionCalculator {
    fun calculate(expression: String?): Int {
        return when (expression) {
            null, "" -> 0
            else -> expression.toInt()
        }
    }
}
