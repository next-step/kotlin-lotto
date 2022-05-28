package calculator.model

import calculator.Const

@JvmInline
value class PositiveNumber(
    private val number: Double
) {
    init {
        validateNaturalNumber(number)
    }

    fun toDouble() = number

    private fun validateNaturalNumber(number: Double) {
        if (number < 0) {
            throw RuntimeException(Const.ErrorMsg.INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_MSG)
        }
    }
}
