package calculator

import java.math.BigDecimal

object StringInputSplitter {
    private const val START_LINE = "//"
    private const val CUSTOM_REGEX = "//(.)\\n(.*)"
    private const val CUSTOM_SEPARATOR_INDEX = 1
    private const val CUSTOM_TOKENS_INDEX = 2

    private val defaultRegex = "[,:]".toRegex()

    fun stringToBigDecimalList(stringNumbers: String?): List<BigDecimal>? =
        if (stringNumbers.isNullOrBlank()) {
            listOf(BigDecimal.ZERO)
        } else if (stringNumbers.contains(START_LINE)) {
            splitToCustomText(stringNumbers)
        } else {
            splitToDefaultText(stringNumbers)
        }

    private fun splitToCustomText(text: String): List<BigDecimal>? =
        Regex(CUSTOM_REGEX).find(text)?.let {
            splitToCustom(it.groupValues[CUSTOM_TOKENS_INDEX], it.groupValues[CUSTOM_SEPARATOR_INDEX])
        }

    private fun splitToDefaultText(text: String): List<BigDecimal> =
        text.split(defaultRegex).map { textToBigDecimal(it.trim()) }

    private fun splitToCustom(text: String, customSeparator: String): List<BigDecimal> =
        text.split(customSeparator).map { textToBigDecimal(it.trim()) }

    private fun textToBigDecimal(text: String): BigDecimal =
        text.toBigDecimalOrNull() ?: throw RuntimeException(MessageCode.NotNumber.message)
}
