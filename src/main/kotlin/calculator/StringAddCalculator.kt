package calculator

import java.util.regex.Pattern

object StringAddCalculator {
    private val CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\n(.*)")
    private val DEFAULT_DELIMITERS = arrayOf(",", ":")
    private const val DELIMITER_INDEX = 1
    private const val NUMBERS_INDEX = 2

    fun calculate(input: String?): Int {
        if (input == null || input.isEmpty()) {
            return 0
        }
        return numbers(input)
            .reduce { a, b -> a + b }
            .value
    }

    private fun numbers(input: String): List<CalculatorNumber> {
        val matcher = CUSTOM_DELIMITER_PATTERN.matcher(input)
        return if (matcher.find()) {
            val delimiter = matcher.group(DELIMITER_INDEX)
            val numbers = matcher.group(NUMBERS_INDEX)
            numbers
                .split(delimiter)
                .map(CalculatorNumber::of)
        } else {
            input
                .split(*DEFAULT_DELIMITERS)
                .map(CalculatorNumber::of)
        }
    }
}
