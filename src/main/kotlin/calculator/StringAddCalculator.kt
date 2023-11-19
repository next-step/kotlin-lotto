package calculator

class StringAddCalculator {
    fun calculate(text: String?): Int {
        val numbers = StringAddCalculatorParser.parse(text)

        if (numbers.isEmpty()) {
            return NULL_OR_BLANK_RETURN_VALUE
        }

        return numbers.sumOf { it.number }
    }

    companion object {
        private const val NULL_OR_BLANK_RETURN_VALUE = 0
    }
}
