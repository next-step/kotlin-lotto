package stringCalculator.strategy

import stringCalculator.domain.StringCalculator

class CustomRegexParserStrategy : ParserStrategy {

    override fun parsingNumber(inputValue: String): List<Int> {
        val result = StringCalculator.customRegexPattern.find(inputValue) ?: throw NullPointerException("null")
        var numberTokens: List<Int> = listOf()

        try {
            result.let { it ->
                val customDelimiter = it.groupValues[1]
                numberTokens = it.groupValues[2].split(customDelimiter)
                    .filter { !it.isBlank() }
                    .map { it.toInt() }
            }
        } catch (e: NumberFormatException) {
            println("숫자가 아닌 값이 존재합니다.")
        }

        return numberTokens
    }
}
