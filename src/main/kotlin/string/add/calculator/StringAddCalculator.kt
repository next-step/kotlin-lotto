package string.add.calculator

object StringAddCalculator {
    private const val COMMA = ","
    private const val COLON = ":"
    private val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)".toRegex()

    fun calculate(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }
        val tokens = split(text)
        val numbers = tokens.map { NaturalNumber(it) }
        return NaturalNumber.sum(numbers).value
    }

    private fun split(text: String): List<String> {
        val matchResult = CUSTOM_DELIMITER_PATTERN.matchEntire(text)
        if (matchResult != null) {
            val (delimiter, numbers) = matchResult.destructured
            return numbers.split(delimiter)
        }
        return text.split(COMMA, COLON)
    }
}
