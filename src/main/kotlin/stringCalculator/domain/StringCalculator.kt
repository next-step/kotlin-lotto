package stringCalculator.domain

import stringCalculator.strategy.CustomRegexParserStrategy
import stringCalculator.strategy.NormalParserStrategy
import stringCalculator.strategy.ParserStrategy
import java.lang.IllegalArgumentException

object StringCalculator {

    const val CUSTOM_REGEX =
        """//(.)\\n(.*)"""
    private const val NUMBER_TOKEN_MIN = 0

    fun doSplit(userInputTemplate: String): Int {
        return if (userInputTemplate.length == 1) getOnlyNumberAddResult(userInputTemplate) else getAnotherAddResult(userInputTemplate)
    }

    private fun getOnlyNumberAddResult(userInputTemplate: String): Int {
        try {
            val userInputValue = userInputTemplate.toInt()
            require(userInputValue >= NUMBER_TOKEN_MIN) { "음수를 입력할 수 없습니다." }
            return userInputTemplate.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닙니다!!!")
        }
    }

    private fun getAnotherAddResult(userInputTemplate: String): Int {
        val isCustomRegex = Regex(CUSTOM_REGEX).matches(userInputTemplate)
        val resultStrategy = getParsingType(isCustomRegex)
        resultStrategy.parsingNumber(userInputTemplate)
        val resultNumberTokens = resultStrategy.numberTokens

        resultNumberTokens.forEach {
            require(it >= NUMBER_TOKEN_MIN) { "음수를 입력할 수 없습니다." }
        }
        return resultNumberTokens.sum()
    }

    private fun getParsingType(result: Boolean): ParserStrategy {
        return if (result) CustomRegexParserStrategy() else NormalParserStrategy()
    }
}
