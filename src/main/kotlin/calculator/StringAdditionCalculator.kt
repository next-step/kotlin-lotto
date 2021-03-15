package calculator

class StringAdditionCalculator {
    fun calculate(expression: String?): Int {
        if (expression.isNullOrBlank()) {
            return 0
        }

        return expression.split(DELIMITER)
            .sumBy { it.toInt() }
    }

    companion object {
        private const val DELIMITER = ","
    }
}
