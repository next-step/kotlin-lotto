package calculator.domain

class Calculator {
    fun calculate(text: String?): Int {
        val numbers = getNumbers(text)
        return numbers.sumOf { convertStringToPositiveInt(it) }
    }

    private fun getNumbers(text: String?): List<String> = when {
        text.isNullOrBlank() -> listOf()
        text.contains(BACKSHASH) && text.contains(NEWLINE) -> getNumbersByCustomSeparator(text)
        text.contains(SEPARATOR.toRegex()) -> text.split(SEPARATOR.toRegex())
        else -> throw IllegalArgumentException(SEPARATOR_EXCEPTION)
    }

    private fun getNumbersByCustomSeparator(text: String): List<String> {
        val result = Regex(CUSTOM_SEPARATOR_PATTERN)
            .findAll(text)
            .map { it.value.trim() }
            .toList()
        val customDelimiter = result[0]
        return result[1].split(customDelimiter)
    }

    private fun convertStringToPositiveInt(number: String): Int {
        val result = number.toIntOrNull()
        require(result != null && result > 0) { NUMBER_TYPE_EXCEPTION }
        return result
    }

    companion object {
        private const val NUMBER_TYPE_EXCEPTION = "양수 타입이 아닙니다."
        private const val SEPARATOR_EXCEPTION = "잘못된 구분자를 입력하셨습니다."
        private const val BACKSHASH = "//"
        private const val NEWLINE = "\\n"
        private const val CUSTOM_SEPARATOR_PATTERN = "(?<=//).|(?<=\\\\n).*"
        private const val SEPARATOR = "[,:]"
    }
}
