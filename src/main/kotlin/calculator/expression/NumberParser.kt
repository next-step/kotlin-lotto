package calculator.expression

class NumberParser private constructor(
    val numbers: List<Int>
) {
    companion object {
        private val DEFAULT_VALUE = listOf(0)

        fun of(input: String?, delimiter: String): NumberParser {
            val numbers = if (input.isNullOrBlank()) {
                DEFAULT_VALUE
            } else {
                val splitInput = input.split(Regex(delimiter))
                val parsedNumbers = splitInput.map { parseNumber(it) }
                validateNumbers(parsedNumbers)
                parsedNumbers
            }
            return NumberParser(numbers)
        }
        private fun parseNumber(value: String): Int {
            return value.toIntOrNull() ?: throw RuntimeException("숫자 형식이 아닙니다.")
        }
        private fun validateNumbers(numbers: List<Int>) {
            if (numbers.any { it < 0 }) {
                throw RuntimeException("음수는 입력할 수 없습니다.")
            }
        }
    }
}
