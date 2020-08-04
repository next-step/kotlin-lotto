package stringCalculator.strategy

import stringCalculator.domain.StringCalculator
import java.lang.IllegalArgumentException

class CustomRegexParserStrategy : ParserStrategy {
    override var numberTokens: List<Int> = listOf()

    override fun parsingNumber(inputValue: String): List<Int> {
        val result = Regex(StringCalculator.CUSTOM_REGEX).find(inputValue) ?: throw NullPointerException("null")

        try {
            result.let { it ->
                val customDelimiter = it.groupValues[1]
                numberTokens = it.groupValues[2].split(customDelimiter)
                    .filter { !it.isNullOrBlank() }
                    .map { it.toInt() }
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닌 값이 존재합니다.")
        }

        return numberTokens
    }
}
