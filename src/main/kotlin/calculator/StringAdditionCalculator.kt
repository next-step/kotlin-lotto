package calculator

class StringAdditionCalculator(private val str: String?) {
    fun add(): Int {
        if (str.isNullOrBlank()) return 0

        val normalizedInput = str.replace("\\n", "\n")
        val matchResult = Regex("//(.*?)\n(.*)").find(normalizedInput)
        val separator = matchResult?.groupValues?.get(1)
        val numbersSection = matchResult?.groupValues?.get(2) ?: str

        val numbers = numbersSection.split(separator?.let { Regex.escape(it).toRegex() } ?: ",|:".toRegex())
        validate(numbers)

        return numbers.sumOf { it.toInt() }
    }

    companion object {
        private val NOT_NUMBER_REGEX = Regex("[^0-9]")
        private const val NOT_NUMBER_MESSAGE = "숫자 이외의 값을 입력할 수 없습니다."
        private const val NEGATIVE_NUMBER_MESSAGE = "음수를 입력할 수 없습니다."

        private fun validate(numbers: List<String>) {
            if (numbers.any { it.matches(NOT_NUMBER_REGEX) }) throw RuntimeException(NOT_NUMBER_MESSAGE)
            if (numbers.any { it.toInt() < 0 }) throw RuntimeException(NEGATIVE_NUMBER_MESSAGE)
        }
    }
}