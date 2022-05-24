package calculator

object CustomDelimiterFinder {
    private val CUSTOM_DELIMITER_REGEX = Regex("""//(.)\\n(.*)""")

    fun find(input: String): MatchResult? {
        return CUSTOM_DELIMITER_REGEX.find(input)
    }
}
