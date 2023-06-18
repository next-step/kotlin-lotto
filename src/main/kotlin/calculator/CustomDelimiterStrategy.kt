package calculator

class CustomDelimiterStrategy : DelimiterStrategy {
    override fun parse(input: String): List<Int>? =
        Regex(CUSTOM_DELIMITER).find(input)?.let { result ->
            parseByCustomDelimiter(result)
        }

    private fun parseByCustomDelimiter(result: MatchResult): List<Int> {
        val customDelimiter = result.groupValues[1]
        val tokens = result.groupValues[2].split(customDelimiter)
        return tokens.map { token -> token.toInt() }
    }

    companion object {
        private const val CUSTOM_DELIMITER = "//(.)\n(.*)"
    }
}
