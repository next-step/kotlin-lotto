package calculator

const val CUSTOM_DELIMITER = "//(.)\n(.*)"
const val DEFAULT_DELIMITER = "[,:]"

class Expression(input: String?) {
    val numbers: List<Int>
    init {
        numbers = if (input.isNullOrBlank()) {
            listOf(0)
        } else {
            val delimiter = determineDelimiter(input)
            val separatedNumbers = separateToNumbers(input)
            val parsedNumbers = parseNumbers(separatedNumbers, delimiter)
            validateNumbers(parsedNumbers)
            parsedNumbers
        }
    }
    private fun separateToNumbers(input: String): String {
        val customDelimiterMatch = Regex(CUSTOM_DELIMITER).find(input)
        return customDelimiterMatch?.groupValues?.get(2) ?: input
    }
    private fun parseNumbers(input: String, delimiter: String): List<Int> {
        return input.split(Regex(delimiter)).map { parseNumber(it) }
    }
    private fun determineDelimiter(input: String): String {
        return Regex(CUSTOM_DELIMITER).find(input)?.let { customDelimiterMatch ->
            Regex.escape(customDelimiterMatch.groupValues[1])
        } ?: DEFAULT_DELIMITER
    }
    private fun parseNumber(value: String): Int {
        return value.toIntOrNull() ?: throw RuntimeException("잘못된 입력입니다.")
    }
    private fun validateNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
    }
}
