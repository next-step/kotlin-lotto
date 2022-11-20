package calculator.util

import calculator.const.ExceptionMessage

object DelimiterExtractor {
    private val SPLIT_REGEX = Regex("//(.*)\n(.*)")
    private val BASIC_DELIMITER = listOf(",", ":")

    fun extract(rawString: String): CalculationInfo {
        val result = SPLIT_REGEX.find(rawString)
        result?.let {
            val customDelimiter = result.groupValues[1]
            validateCustomDelimiter(customDelimiter)
            return CalculationInfo(BASIC_DELIMITER + customDelimiter, result.groupValues[2])
        }
        return CalculationInfo(BASIC_DELIMITER, rawString)
    }

    private fun validateCustomDelimiter(customDelimiter: String) {
        require(customDelimiter.isNotEmpty()) { ExceptionMessage.CUSTOM_DELIMITER_EMPTY_STRING_ERROR }
    }
}
