package stringCalculator.domain

import stringCalculator.strategy.ParserStrategy.Companion.getParserStrategy
import stringCalculator.view.showMessage

object StringCalculator {

    const val DEFAULT_VALUE = 0
    private const val NUMBER_TOKEN_MIN = 0

    fun doSplit(userInputTemplate: String): Int {
        return if (userInputTemplate.length == 1) getOnlyNumberAddResult(userInputTemplate) else getAnotherAddResult(
            userInputTemplate
        )
    }

    private fun getOnlyNumberAddResult(userInputTemplate: String): Int {
        // [질문] null이 되는 값을 0으로 처리하는게 맞는건가요?
        return userInputTemplate.toIntOrNull() ?: DEFAULT_VALUE
    }

    private fun getAnotherAddResult(userInputTemplate: String): Int {
        val resultStrategy = getParserStrategy(userInputTemplate)
        val resultNumberTokens = resultStrategy.parsingNumber(userInputTemplate)

        resultNumberTokens.forEach {
            if (it >= NUMBER_TOKEN_MIN) {
                checkNegativeNumber()
            }
        }
        return resultNumberTokens.sum()
    }

    // [질문] exception을 발생시키기위해 아래처럼 사용해도 되나요?
    private fun checkNegativeNumber() {
        try {
        } catch (e: RuntimeException) {
            showMessage("음수를 입력할 수 없습니다.", e)
        }
    }
}
