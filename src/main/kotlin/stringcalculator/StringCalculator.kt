package stringcalculator

class StringCalculator {
    fun add(expression: String): Int {
        val numbers = expression.split(*DELIMITERS).map { it.toInt() }
        return numbers.sum()
    }

    companion object {
        private const val COMMA = ","
        private const val COLON = ":"
        private val DELIMITERS = arrayOf(COMMA, COLON)
    }
}
