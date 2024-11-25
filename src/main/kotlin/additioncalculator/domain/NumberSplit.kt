package additioncalculator.domain

import java.lang.RuntimeException

class NumberSplit(private val text: String?) {
    fun splitNumberResult(): Numbers {
        if(text.isNullOrEmpty()) return Numbers(listOf())
        if(text.toIntOrNull() != null && text.toIntOrNull()!! < NUMBER_MINIMUM)
            throw RuntimeException(INVALID_NEGATIVE_MESSAGE)
        if(text.toIntOrNull() != null ) return Numbers(listOf(text.toInt()))
        val delimiters: List<String> = Delimiters(text).findDelimiters()
        val transferText: String = text.replace(Regex(REPLACE_CUSTOM_DELIMITER_REGEX_PATTERN), "")
        return Numbers(splitTextsToInts(transferText.split(*delimiters.toTypedArray())))
    }

    private fun splitTextsToInts(splitTexts: List<String>): List<Int> {
        return splitTexts.map { splitText -> nullCheckTextToInt(splitText) }
    }

    private fun nullCheckTextToInt(text: String): Int {
        val numberOrNull: Int? = text.toIntOrNull()
        requireNotNull(numberOrNull) { INVALID_NUMBER_TRANSFER }
        if(numberOrNull < NUMBER_MINIMUM) throw RuntimeException(INVALID_NEGATIVE_MESSAGE)
        return numberOrNull
    }

    companion object {
        const val REPLACE_CUSTOM_DELIMITER_REGEX_PATTERN: String = "//(.)\\n"
        const val NUMBER_MINIMUM: Int = 0
        const val INVALID_NEGATIVE_MESSAGE: String = "음수는 불가합니다"
        const val INVALID_NUMBER_TRANSFER: String = "계산이 불가한 문자열 입니다"
    }
}