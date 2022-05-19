package string.addition.caculator.application

import string.addition.caculator.domain.Operand

object OperandParser {
    private const val DEFAULT_DELIMITER_PATTERN = "[,:]"
    private const val CUSTOM_DELIMITER_PATTERN = "//(.)\\\\n(.*)"

    fun parse(inputStr: String): List<Operand> {
        val customDelimiterResult = Regex(CUSTOM_DELIMITER_PATTERN).find(inputStr)
        return if (customDelimiterResult == null) {
            parseByDelimiter(
                operandsStr = inputStr,
                delimiter = DEFAULT_DELIMITER_PATTERN.toRegex()
            )
        } else {
            parseByDelimiter(
                operandsStr = customDelimiterResult.groupValues[2],
                delimiter = customDelimiterResult.groupValues[1].toRegex()
            )
        }
    }

    private fun parseByDelimiter(operandsStr: String, delimiter: Regex): List<Operand> {
        return if (operandsStr.isEmpty()) {
            listOf(Operand.zero)
        } else {
            operandsStr.split(delimiter)
                .map { Operand(it) }
        }
    }
}
