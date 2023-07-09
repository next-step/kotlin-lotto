package calculator

class DefaultParsingRegex : ParsingRegex {
    override fun find(text: String): MatchResult? = CUSTOM_DELIMITER_REGEX.find(text)

    companion object {
        private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    }
}
