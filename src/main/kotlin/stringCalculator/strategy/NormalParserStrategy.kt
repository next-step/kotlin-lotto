package stringCalculator.strategy

import java.lang.IllegalArgumentException

class NormalParserStrategy : ParserStrategy {
    override var numberTokens: List<Int> = listOf()

    override fun parsingNumber(inputValue: String): List<Int> {
        try {
            numberTokens = inputValue.split(DELIMITER_TYPE_COMMA, DELIMITER_TYPE_COLON)
                .filter { !it.isNullOrBlank() }
                .map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닌 값이 존재합니다.")
        }
        return numberTokens
    }

    companion object {
        const val DELIMITER_TYPE_COMMA = ","
        const val DELIMITER_TYPE_COLON = ":"
    }
}
