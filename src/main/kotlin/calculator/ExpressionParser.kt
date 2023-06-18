package calculator

object ExpressionParser {

    fun hasCustomDelimiter(input: String): Boolean =
        input.startsWith("//") && input.contains("\n")

    fun parse(
        input: String,
        delimiterStrategy: DelimiterStrategy
    ): List<Int> = delimiterStrategy.parse(input) ?: listOf(parseUniNumber(input))

    private fun parseUniNumber(input: String): Int {
        val uniNumber = input.toIntOrNull()
        if (uniNumber == null || uniNumber < 0) {
            throw RuntimeException()
        }
        return uniNumber
    }
}
