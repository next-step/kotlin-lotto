package calculator

class StringCalculator {
    fun calculate(input: String): Int {
        val numbers = input.split(DEFAULT_DELIMITER_COMMA, DEFAULT_DELIMITER_COLON)
        return numbers.sumOf { it.toInt() }
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_COLON = ":"
    }
}
