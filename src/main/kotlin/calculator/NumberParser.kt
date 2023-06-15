package calculator

class NumberParser(input: String?, delimiter: String) {

    val numbers: List<Int>

    init {
        numbers = if (input.isNullOrBlank()) {
            DEFAULT_VALUE
        } else {
            val splitInput = input.split(Regex(delimiter))
            val parsedNumbers = splitInput.map { parseNumber(it) }
            validateNumbers(parsedNumbers)
            parsedNumbers
        }
    }

    private fun parseNumber(value: String): Int {
        return value.toIntOrNull() ?: throw RuntimeException("숫자 형식이 아닙니다.")
    }

    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }
    companion object {
        val DEFAULT_VALUE = listOf(0)
    }
}
