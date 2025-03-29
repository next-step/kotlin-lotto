package stringcalculator

class StringCalculator {
    fun add(expression: String): Int {
        val numbers = expression.split(DELIMITER).map { it.toInt() }
        return numbers.sum()
    }

    companion object {
        private const val DELIMITER = ","
    }
}
