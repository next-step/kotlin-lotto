package string.add.calculator

class StringAddCalculator {
    private val parser = StringAddCalculatorParser()

    fun add(text: String?): Int {
        return calculateOrDefault(text)
    }

    private fun calculateOrDefault(text: String?): Int {
        if (text.isNullOrEmpty()) {
            return DEFAULT_RESULT
        }

        if (text.isBlank()) {
            return DEFAULT_RESULT
        }

        return calculate(text)
    }

    private fun calculate(text: String): Int {
        val numberStrings = parser.parseText(text)
        val numbers = convertToIntList(numberStrings)

        return numbers.sum()
    }

    private fun convertToIntList(numberStrings: List<String>): List<Int> {
        val numbers = numberStrings.map {
            it.toIntOrNull() ?: throw RuntimeException(ErrorMessage.NON_NUMERIC_VALUE_WAS_PASSED.message)
        }

        validateNumbers(numbers)
        return numbers
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException(ErrorMessage.NEGATIVE_NUMBER_PASSED.message)
        }
    }

    companion object {
        private const val DEFAULT_RESULT: Int = 0
    }
}
