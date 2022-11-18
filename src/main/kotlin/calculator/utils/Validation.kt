package calculator.utils

object Validation {

    private val NUMERIC_REGEX = Regex("[0-9]")
    private val NEGATIVE_NUMBER_REGEX = Regex("^(-[1-9])")

    fun isNumeric(str: String) =
        NUMERIC_REGEX.containsMatchIn(str)

    fun isNegativeNumber(str: String) =
        NEGATIVE_NUMBER_REGEX.containsMatchIn(str)

    fun isNumericAndNegativeNumber(strings: List<String>) =
        strings.forEach {
            if (!isNumeric(it)) throw RuntimeException("입력된 값이 숫자가 아닙니다.")
            if (isNegativeNumber(it)) throw RuntimeException("입력된 값이 음수 입니다.")
        }
}
