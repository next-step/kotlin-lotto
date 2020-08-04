package stringCalculator.strategy

class NormalParserStrategy : ParserStrategy {

    override fun parsingNumber(inputValue: String): List<Int> {
        var numberTokens: List<Int> = listOf()
        try {
            numberTokens = inputValue.split(DELIMITER_TYPE_COMMA, DELIMITER_TYPE_COLON)
                .filter { !it.isBlank() }
                .map { it.toInt() }
        } catch (e: NumberFormatException) {
            println("숫자가 아닌 값이 존재합니다.")
        }
        return numberTokens
    }

    companion object {
        const val DELIMITER_TYPE_COMMA = ","
        const val DELIMITER_TYPE_COLON = ":"
    }
}
