package calculator

import calculator.StringDelimiterSeparator.Companion.split
import calculator.WholeNumber.Companion.sum

object StringAddCalculator {

    private const val DEFAULT_VALUE: Int = 0
    private val CUSTOM_SEPARATOR: StringDelimiterSeparator =
        StringDelimiterSeparator("^//(?<delimiter>.)\n(?<strings>.*)\$".toRegex())
    private val DEFAULT_DELIMITER: Regex = "[,:]".toRegex()

    val String?.splitAndSum: Int
        get() {
            if (isNullOrBlank()) {
                return DEFAULT_VALUE
            }
            return (split(CUSTOM_SEPARATOR) ?: split(DEFAULT_DELIMITER))
                .map { WholeNumber(it) }
                .sum
                .value
        }
}
