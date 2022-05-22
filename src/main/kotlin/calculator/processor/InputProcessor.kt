package calculator.processor

import calculator.Const
import calculator.model.PositiveNumber

class InputProcessor {
    fun convertStringToList(text: String?): List<PositiveNumber> {
        val notEmptyText = convertStringToZeroIfNull(text)
        return splitToDelimiter(notEmptyText)
            .map {
                val number = it.trim().toDoubleOrNull()
                    ?: throw RuntimeException(Const.ErrorMsg.INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_MSG)
                PositiveNumber(number)
            }
    }

    private fun convertStringToZeroIfNull(text: String?) =
        text.takeIf { !it.isNullOrBlank() } ?: ZERO_STR

    private fun splitToDelimiter(text: String): List<String> {
        val matchResult = CUSTOM_DELIMITER_REGEX.find(text)
        return matchResult?.let {
            val (customDelimiter, tokens) = matchResult.destructured
            requireDelimiterIsNotPeriod(customDelimiter)
            tokens.split(customDelimiter)
        } ?: text.split(DEFAULT_DELIMITER_REGEX)
    }

    private fun requireDelimiterIsNotPeriod(delimiter: String) =
        require(delimiter != PERIOD_STR) { Const.ErrorMsg.CANNOT_USE_PERIOD_FOR_DELIMITER }

    companion object {
        private const val ZERO_STR = "0"
        private const val PERIOD_STR = "."
        private val CUSTOM_DELIMITER_REGEX = Regex("""//(.)\\n(.*)""")
        private val DEFAULT_DELIMITER_REGEX = Regex(",|:")
    }
}
