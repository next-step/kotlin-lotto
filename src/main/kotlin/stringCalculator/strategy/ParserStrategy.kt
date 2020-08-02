package stringCalculator.strategy

interface ParserStrategy {
    var numberTokens: List<Int>
    fun parsingNumber(inputValue: String): List<Int>
}
