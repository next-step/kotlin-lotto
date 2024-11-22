package calculator

import calculator.parser.TextParser

class StringAdditionCalculator(
    private val parser: TextParser,
) {
    fun calculate(text: String?): Int {
        val numbers = parser.parse(text)
        validate(numbers)

        if (numbers.isEmpty()) {
            return 0
        }

        return numbers.reduce(Int::plus)
    }

    private fun validate(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw IllegalArgumentException("음수는 입력할 수 없습니다.")
        }
    }
}
