package calculator

import math.PositiveNumber

object StringParser {

    private val CUSTOM_DELIMITER_REGEX = Regex("//(.)\n(.*)")
    private const val FIXED_DELIMITERS = ",:"

    fun parse(source: String): List<PositiveNumber> {
        if (source.isBlank()) {
            return emptyList()
        }

        val matchedGroupValues = CUSTOM_DELIMITER_REGEX.find(source)?.groupValues
        val delimiters = matchedGroupValues?.getOrNull(1)
            ?.let { customDelimiter -> FIXED_DELIMITERS.plus(customDelimiter) }
            ?: FIXED_DELIMITERS
        val calculationTargetText = matchedGroupValues?.getOrNull(2) ?: source

        return calculationTargetText
            .split(Regex("[$delimiters]"))
            .map { maybeNumber -> PositiveNumber.of(maybeNumber) }
    }
}
