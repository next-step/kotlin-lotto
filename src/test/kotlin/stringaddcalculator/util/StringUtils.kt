package stringaddcalculator.util

import stringaddcalculator.domain.PositiveNumber

object StringUtils {
    private const val DEFAULT_DELIMITER = "[,:]"
    private const val CUSTOM_DELIMITER = "//(.)\n(.*)"

    fun splitCustomDelimiterOrDefaultDelimiter(text: String): List<PositiveNumber> {
        val result = Regex(CUSTOM_DELIMITER).find(text)
        result?.let { matchResult ->
            val customDelimiter = matchResult.groupValues[1]
            return matchResult.groupValues[2].split(customDelimiter).map { PositiveNumber(it) }
        }.let {
            return text.split(DEFAULT_DELIMITER.toRegex()).map { PositiveNumber(it) }
        }
    }
}
