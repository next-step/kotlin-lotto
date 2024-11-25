package calculator

import calculator.parser.TextParser

class StringAdditionCalculator(
    private val parser: TextParser,
) {
    fun calculate(text: String?): Int {
        val numbers = parser.parse(text)

        if (numbers.isEmpty()) {
            return 0
        }

        return numbers.reduce(PositiveNumber::plus).value
    }
}
