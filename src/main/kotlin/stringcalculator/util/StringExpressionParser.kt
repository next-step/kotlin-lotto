package stringcalculator.util

import stringcalculator.util.StringExpressionValidator.isNotOneDigitNaturalNumber

object StringExpressionParser {
    private const val INVALID_NUMBER_ERR_MESSAGE = "[Error] : Invalid number value"
    private const val COMMA_DELIMITER = ","
    private const val COLON_DELIMITER = ":"
    private const val DELIMITER_GROUP = 1
    private const val EXPRESSION_GROUP = 2
    private val CUSTOM_DELIMITER_REGEX: Regex = Regex("//(.)\n(.*)")

    fun String.splitByDefaultDelimiter(): List<String> =
        this.split(COMMA_DELIMITER, COLON_DELIMITER)

    fun String.splitByCustomDelimiter(): List<String> =
        CUSTOM_DELIMITER_REGEX.find(this)
            ?.let {
                val customDelimiter = it.groupValues[DELIMITER_GROUP]
                it.groupValues[EXPRESSION_GROUP]
                    .split(customDelimiter)
            } ?: listOf()

    fun String.toOneDigitNaturalNumber(): Int {
        if (this.isNotOneDigitNaturalNumber()) {
            throw RuntimeException(INVALID_NUMBER_ERR_MESSAGE)
        }

        return this.toInt()
    }
}
