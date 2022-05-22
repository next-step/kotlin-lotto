package string.addition.caculator.application

import string.addition.caculator.domain.Operand

object OperandParser {
    private val DEFAULT_DELIMITER_PATTERN = Regex("[,:]")
    private val CUSTOM_DELIMITER_PATTERN = Regex("//(.)\\\\n(.*)")

    fun parse(inputStr: String): List<Operand> {

        return when (val customDelimiterResult = CUSTOM_DELIMITER_PATTERN.find(inputStr)) {
            null -> parseByDelimiter(inputStr, DEFAULT_DELIMITER_PATTERN)
            else -> parseByDelimiter(customDelimiterResult.groupValues[2], Regex(customDelimiterResult.groupValues[1]))
        }
    }

    private fun parseByDelimiter(operandsStr: String, delimiter: Regex): List<Operand> {
        return when {
            operandsStr.isEmpty() -> listOf(Operand.zero)
            else -> operandsStr.split(delimiter).map { Operand(it) }
        }
    }
}
