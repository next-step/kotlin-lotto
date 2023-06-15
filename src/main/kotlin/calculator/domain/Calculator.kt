package calculator.domain

private const val NUMBER_TYPE_EXCEPTION = "양수 타입이 아닙니다."
private const val SEPARATOR_EXCEPTION = "잘못된 구분자를 입력하셨습니다."
private const val BACKSHASH = "//"
private const val NEWLINE = "\\n"
private const val CUSTOM_SEPARATOR_PATTERN = "(?<=//).|(?<=\\\\n).*"
private const val SEPARATOR = "[,:]"

class Calculator(text: String?) {
    val numbers: List<String>

    init {
        numbers = when {
            text.isNullOrBlank() -> {
                listOf()
            }

            text.contains(BACKSHASH) && text.contains(NEWLINE) -> {
                val result = Regex(CUSTOM_SEPARATOR_PATTERN)
                    .findAll(text)
                    .map { it.value.trim() }
                    .toList()
                val customDelimiter = result[0]
                result[1].split(customDelimiter)
            }

            text.contains(SEPARATOR.toRegex()) -> text.split(SEPARATOR.toRegex())
            else -> throw IllegalArgumentException(SEPARATOR_EXCEPTION)
        }
    }

    private fun convertStringToPositiveInt(number: String): Int {
        val result = number.toIntOrNull()
        require(result != null && result > 0) { NUMBER_TYPE_EXCEPTION }
        return result
    }

    val result = numbers.sumOf { convertStringToPositiveInt(it) }
}
