package stringCalculator.strategy

class CustomRegexParserStrategy : ParserStrategy {

    val CUSTOM_REGEX_PATTERN = Regex("//(.)\\\\n(.*)")

    override fun parsingNumber(inputValue: String): List<Int> {
        val result = CUSTOM_REGEX_PATTERN.find(inputValue) ?: throw NullPointerException("null")
        var numberTokens: List<Int> = listOf()

        result.let { it ->
            val customDelimiter = it.groupValues[1]
            numberTokens = it.groupValues[2].split(customDelimiter)
                .filter { !it.isBlank() }
                .map { it.toIntOrNull() ?: DEFAULT_VALUE } // 여기도 이런식으로 디폴트값을 주면 될까요?
        }

        return numberTokens
    }
    companion object {
        const val DEFAULT_VALUE = 0
    }
}
