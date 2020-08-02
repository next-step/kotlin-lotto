package calculate

class DelimiterSetter(inputs: String) {
    private val matchResult = getMatchResult(inputs)

    val delimiter = getDelimiter(matchResult)
    val body = if (matchResult == null) inputs else matchResult.groupValues[2]

    private fun getMatchResult(inputs: String): MatchResult? {
        return Regex(CUSTOM_DELIMITER_PATTERN).find(inputs)
    }

    private fun getDelimiter(matchResult: MatchResult?): List<String> {
        if (matchResult == null) return listOf(
            DEFAULT_DELIMITER_COMMA,
            DEFAULT_DELIMITER_COLON
        )

        return listOf(matchResult.groupValues[1])
    }

    companion object {
        private const val DEFAULT_DELIMITER_COMMA = ","
        private const val DEFAULT_DELIMITER_COLON = ":"
        private const val CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)"
    }
}
