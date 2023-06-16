package calculator

object ExpressionParser {

    private const val DEFAULT_DELIMITERS = "[,:]"
    private const val CUSTOM_DELIMITER = "//(.)\n(.*)"

    fun parse(input: String): List<Int> {
        Regex(CUSTOM_DELIMITER).find(input)?.let { result ->
            return parseByCustomDelimiter(result)
        }

        Regex(DEFAULT_DELIMITERS).find(input)?.let { _ ->
            return parseByDefaultDelimiter(input)
        }

        return listOf(parseUniNumber(input))
    }

    private fun parseByCustomDelimiter(result: MatchResult): List<Int> {
        val customDelimiter = result.groupValues[1]
        val tokens = result.groupValues[2].split(customDelimiter)
        return tokens.map { token -> token.toInt() }
    }

    private fun parseByDefaultDelimiter(input: String): List<Int> =
        input.split(DEFAULT_DELIMITERS.toRegex())
            .map { it.toInt() }

    private fun parseUniNumber(input: String): Int {
        val uniNumber = input.toIntOrNull()
        if (uniNumber == null || uniNumber < 0) {
            throw RuntimeException()
        }
        return uniNumber
    }
}
