package stringAddCalculator

class StringAddCalculator {
    fun calculate(input: String?): Int {
        if (input.isNullOrEmpty()) {
            return EMPTY_RESULT
        }

        return StringAddCalculatorInput(input).parse().sumOf { it }
    }

    companion object {
        private const val EMPTY_RESULT = 0
    }
}
