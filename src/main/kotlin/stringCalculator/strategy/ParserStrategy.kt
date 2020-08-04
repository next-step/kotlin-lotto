package stringCalculator.strategy

interface ParserStrategy {
    var numberTokens: List<Int>
    fun parsingNumber(inputValue: String): List<Int>

    companion object {
        fun getParserStrategy(hasCustomRegex: Boolean): ParserStrategy {
            return if (hasCustomRegex) CustomRegexParserStrategy() else NormalParserStrategy()
        }
    }
}
