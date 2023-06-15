package calculator.domain

class Calculator() {
    var numbers: List<String> = listOf()
        private set
    var result: Int = 0
        private set

    fun calculate(text: String?) {
        this.numbers = getNumbers(text)
        this.result = this.numbers.sumOf { convertStringToPositiveInt(it) }
    }

    private fun getNumbers(text: String?): List<String> = when {
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
