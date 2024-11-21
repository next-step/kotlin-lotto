package calculator

class StringAdditionCalculator {
    fun add(str: String?): Int {
        if (str.isNullOrBlank()) return 0

        val (separator, numbersSection) = parseInput(str)

        val numbers = numbersSection.split(separator?.let { Regex.escape(it).toRegex() } ?: DEFAULT_SEPARATOR.toRegex())
        validate(numbers)

        return numbers.sumOf { it.toInt() }
    }

    private fun parseInput(input: String?): Pair<String?, String> {
        val normalizedInput = input?.replace("\\n", "\n") ?: ""
        val matchResult = Regex("//(.*?)\n(.*)").find(normalizedInput)
        val separator = matchResult?.groupValues?.get(CUSTOM_SEPARATOR_INDEX)
        val numbersSection = matchResult?.groupValues?.get(NUMBERS_INDEX) ?: input ?: ""
        return Pair(separator, numbersSection)
    }

    companion object {
        private val NOT_NUMBER_REGEX = Regex("[^0-9]")
        private const val NOT_NUMBER_MESSAGE = "숫자 이외의 값을 입력할 수 없습니다."
        private const val NEGATIVE_NUMBER_MESSAGE = "음수를 입력할 수 없습니다."
        private const val DEFAULT_SEPARATOR = ",|:"
        private const val CUSTOM_SEPARATOR_INDEX = 1
        private const val NUMBERS_INDEX = 2

        private fun validate(numbers: List<String>) {
            if (numbers.any { it.matches(NOT_NUMBER_REGEX) }) throw IllegalArgumentException(NOT_NUMBER_MESSAGE)
            if (numbers.any { it.toInt() < 0 }) throw IllegalArgumentException(NEGATIVE_NUMBER_MESSAGE)
        }
    }
}
