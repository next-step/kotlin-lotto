package stringCalculator.strategy

import stringCalculator.domain.StringCalculator
import stringCalculator.view.showMessage

class CustomRegexParserStrategy : ParserStrategy {

    override fun parsingNumber(inputValue: String): List<Int> {
        val result = StringCalculator.customRegexPattern.find(inputValue) ?: throw NullPointerException("null")
        var numberTokens: List<Int> = listOf()

        try {
            result.let { it ->
                val customDelimiter = it.groupValues[1]
                numberTokens = it.groupValues[2].split(customDelimiter)
                    .filter { !it.isBlank() }
                    .map { it.toIntOrNull() ?: DEFAULT_VALUE } // 여기도 이런식으로 디폴트값을 주면 될까요?
            }
        } catch (e: NumberFormatException) {
            showMessage("숫자가 아닌 값이 존재합니다.", e)
        }
        return numberTokens
    }
    companion object {
        const val DEFAULT_VALUE = 0
    }
}
