package calculator

import calculator.PositiveNumber.Companion.sum

class StringCalculator(private val inputString: String?) {

    fun calculate(): Int {
        return if (inputString.isNullOrBlank()) {
            RESULT_EMPTY_VALUE
        } else {
            val matchResult: MatchResult? = Regex(REGEX_DIVIDER).find(inputString)
            val divider = extractionDivider(matchResult)

            require(divider.isNotEmpty()) { "구분자를 찾지 못 했습니다" }

            val numberStrings = splitNumberStrings(divider, matchResult)
            val numbers = stringsToNumbers(numberStrings)
            numbers.sum()
        }
    }

    private fun extractionDivider(matchResult: MatchResult?): String = when (matchResult) {
        null -> DEFAULT_DIVIDER
        else -> extractionCustomDivider(matchResult)
    }

    private fun extractionCustomDivider(matchResult: MatchResult): String =
        matchResult.groupValues[1]

    private fun splitNumberStrings(divider: String, matchResult: MatchResult?): List<String> {
        val convertString: String = when (matchResult) {
            null -> inputString!!
            else -> matchResult.groupValues[2]
        }

        return convertString.split(divider.toRegex())
    }

    private fun stringsToNumbers(numberStrings: List<String>): List<PositiveNumber> {
        return numberStrings.map { PositiveNumber(it.toUInt()) }
    }

    companion object {
        private const val DEFAULT_DIVIDER = ",|:"
        private const val REGEX_DIVIDER = "//(.)\n(.*)"
        private const val RESULT_EMPTY_VALUE = 0
    }
}
