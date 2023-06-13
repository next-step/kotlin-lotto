package calculator

const val CUSTOM_DELIMITER = "//(.)\n(.*)"
const val DEFAULT_DELIMITER = "[,:]"
class StringAddCalculator {
    private var numbers: List<Int> = ArrayList()
    fun separateStrings(input: String?): List<Int> {
        val separatedNumbers = if (input.isNullOrBlank()) {
            listOf(0)
        } else {
            val customDelimiterMatch = Regex(CUSTOM_DELIMITER).find(input)
            if (customDelimiterMatch != null) {
                val customDelimiter = Regex.escape(customDelimiterMatch.groupValues[1])
                customDelimiterMatch.groupValues[2].split(Regex(customDelimiter)).map { parseNumber(it) }
            } else {
                input.split(Regex(DEFAULT_DELIMITER)).map { parseNumber(it) }
            }
        }
        numbers = separatedNumbers
        return separatedNumbers
    }
    private fun parseNumber(value: String): Int {
        return value.toIntOrNull() ?: throw RuntimeException("잘못된 입력입니다.")
    }
    fun add(): Int {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("음수는 입력할 수 없습니다.")
        }
        return numbers.sum()
    }
}
