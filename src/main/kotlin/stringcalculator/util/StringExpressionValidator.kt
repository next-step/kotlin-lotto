package stringcalculator.util

object StringExpressionValidator {
    private const val ONE_DIGIT_NATURAL_NUMBER_EXP = "^[0-9]$"
    private val NATURAL_NUMBER_REGEX = Regex(ONE_DIGIT_NATURAL_NUMBER_EXP)

    fun String.isOneDigitNaturalNumber(): Boolean = this.matches(NATURAL_NUMBER_REGEX)
}
