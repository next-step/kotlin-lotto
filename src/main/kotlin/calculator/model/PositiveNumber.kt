package calculator.model

import calculator.Const

@JvmInline
value class PositiveNumber(
    private val numberStr: String
) {
    init {
        val number = stringToDouble()
        validateNaturalNumber(number)
    }

    fun toDouble() = numberStr.toDouble()

    private fun stringToDouble() =
        numberStr.toDoubleOrNull()
            ?: throw RuntimeException(Const.ErrorMsg.INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_MSG)

    private fun validateNaturalNumber(number: Double) {
        if (number < 0) {
            throw RuntimeException(Const.ErrorMsg.INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_MSG)
        }
    }
}
