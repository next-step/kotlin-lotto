package calculator.domain

private const val NUMBER_TYPE_EXCEPTION = "양수 타입이 아닙니다."

private const val SEPARATOR_EXCEPTION = "잘못된 구분자를 입력하셨습니다."

private const val COMMA_SEPARATOR = ","

private const val COLON_SEPARATOR = ":"

private const val NEWLINE_SEPARATOR = "\\n"

private const val BACKSLASH_SEPARATOR = "//"

private const val SEPARATOR_PATTERN = "(?<=//).|(?<=\\\\n).*"

private const val BLANK = ""

class Calculator(text: String?) {
    val separator: String
    val numbers: List<Int>

    init {
        var numberText = text
        separator = when {
            text.isNullOrBlank() -> {
                numberText = BLANK
                BLANK
            }

            text.contains(BACKSLASH_SEPARATOR) && text.contains(NEWLINE_SEPARATOR) -> {
                val result = Regex(SEPARATOR_PATTERN)
                    .findAll(text)
                    .map { it.value.trim() }
                    .toList()
                numberText = result[1]
                result[0]
            }

            text.contains(COMMA_SEPARATOR) -> COMMA_SEPARATOR
            text.contains(COLON_SEPARATOR) -> COLON_SEPARATOR
            else -> throw IllegalArgumentException(SEPARATOR_EXCEPTION)
        }
        numbers = numberText!!.split(separator)
            .filter { it.isNotBlank() }
            .map { isPositiveNumber(it) }
    }

    private fun isPositiveNumber(number: String): Int {
        val result = number.toIntOrNull()
        require(result != null && result > 0) { NUMBER_TYPE_EXCEPTION }
        return result
    }

    val result = numbers.sum()
}
