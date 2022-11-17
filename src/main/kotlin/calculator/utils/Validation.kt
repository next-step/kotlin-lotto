package calculator.utils

object Validation {

    fun isNumeric(str: String) =
        Regex("[0-9]").containsMatchIn(str)

    fun isNegativeNumber(str: String) =
        Regex("^(-[1-9])").containsMatchIn(str)
}
