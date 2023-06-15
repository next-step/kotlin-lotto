package calculator

object ExpressionParser {

    private const val DEFAULT_DELIMITERS = "[,:]"
    private const val CUSTOM_DELIMITER = "//(.)\n(.*)"

    fun parse(input: String): Int {
        Regex(CUSTOM_DELIMITER).find(input)?.let { result ->
            return parseByCustomDelimiter(result)
        }

        Regex(DEFAULT_DELIMITERS).find(input)?.let { _ ->
            return parseByDefaultDelimiter(input)
        }

        return parseUniNumber(input)
    }

    private fun parseByCustomDelimiter(result: MatchResult): Int {
        val customDelimiter = result.groupValues[1]
        val tokens = result.groupValues[2].split(customDelimiter)

        return tokens.sumOf { token -> token.toInt() }
    }

    private fun parseByDefaultDelimiter(input: String): Int =
        input.split(DEFAULT_DELIMITERS.toRegex())
            .sumOf { it.toInt() }

    private fun parseUniNumber(input: String): Int {
        val uniNumber = input.toIntOrNull()
        if (uniNumber == null || uniNumber < 0) {
            throw RuntimeException()
        }
        return uniNumber
    }
}
