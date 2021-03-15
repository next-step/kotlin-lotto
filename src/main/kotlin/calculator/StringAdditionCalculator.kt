package calculator

class StringAdditionCalculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }

        return expression.toIntOrNull()
            ?: expression.split(",").map { it.toInt() }.sum()
    }
}
