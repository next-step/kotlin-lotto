package additioncalculator.domain

import java.lang.RuntimeException

object NumberSplit {
    fun textSplitToNumbers(textOrNull: String?): List<Int> {
        if (textOrNull.isNullOrBlank()) {
            return listOf()
        }

        val singleNumberOrNull = textOrNull.toIntOrNull()
        if (singleNumberOrNull != null) {
            checkNumberMinimum(checkNumber = singleNumberOrNull)
            return listOf(singleNumberOrNull.toInt())
        }

        val delimiters: List<String> = DelimiterScanner.findDelimiters(inputText = textOrNull)
        val transferStringToSplit: String =
            textOrNull.replace(Regex(REPLACE_CUSTOM_DELIMITER_REGEX_PATTERN), "")

        return singleNumberTextsToInts(singleNumberTexts = transferStringToSplit.split(*delimiters.toTypedArray()))
    }

    private fun checkNumberMinimum(checkNumber: Int) {
        if (checkNumber < NUMBER_MINIMUM) {
            throw RuntimeException(INVALID_NEGATIVE_MESSAGE)
        }
    }

    private fun singleNumberTextsToInts(singleNumberTexts: List<String>): List<Int> {
        return singleNumberTexts.map { singleNumberText -> singleNumberTextToInt(singleNumberText = singleNumberText) }
    }

    private fun singleNumberTextToInt(singleNumberText: String): Int {
        val numberOrNull: Int? = singleNumberText.toIntOrNull()
        requireNotNull(numberOrNull) { INVALID_NUMBER_TRANSFER }

        if (numberOrNull < NUMBER_MINIMUM) {
            throw RuntimeException(INVALID_NEGATIVE_MESSAGE)
        }

        return numberOrNull
    }

    private const val REPLACE_CUSTOM_DELIMITER_REGEX_PATTERN: String = "//(.)\\n"
    private const val NUMBER_MINIMUM: Int = 0
    const val INVALID_NEGATIVE_MESSAGE: String = "음수는 불가 합니다"
    const val INVALID_NUMBER_TRANSFER: String = "계산이 불가한 문자열 입니다"
}
