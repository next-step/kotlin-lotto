package stringAddCalculator

class StringAddCalculatorInput(private val input: String) {
    fun parse(): List<Int> {
        val (customDelimiter, integerPart) = getCustomDelimiter()
            ?.destructured
            ?.let { (customDelimiter, integerPart) -> Pair(customDelimiter, integerPart) }
            ?: Pair(
                EMPTY_CUSTOM_DELIMITER,
                input
            )

        return convertToIntList(integerPart, customDelimiter)
    }

    private fun convertToIntList(target: String, customDelimiter: String): List<Int> {
        return target.split(Regex("[${DEFAULT_DELIMITERS.joinToString()}$customDelimiter]"))
            .map {
                convertToInt(it)
            }
    }

    private fun getCustomDelimiter() = Regex(CUSTOM_DELIMITER_PATTERN).find(input)

    private fun convertToInt(text: String): Int = text.toIntOrNull()
        ?.takeIf { it >= MIN_VALID_NUMBER }
        ?: throw RuntimeException()

    companion object {
        private val DEFAULT_DELIMITERS = listOf(",", ":")
        private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"
        private const val EMPTY_CUSTOM_DELIMITER = ""
        private const val MIN_VALID_NUMBER = 0
    }
}
