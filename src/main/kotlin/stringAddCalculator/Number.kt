package stringAddCalculator

import stringAddCalculator.StringAddCalculator.Companion.ZERO

data class Number(private val number: Int) {
    init {
        if (isNegativeNumber(number)) throw RuntimeException("$NEGATIVE_NUMBER_THROW_MESSAGE $number")
    }

    fun getNumber() = number

    fun plus(targetNumber: Number) = Number(number.plus(targetNumber.number))

    private fun isNegativeNumber(number: Int) = number < ZERO

    companion object {
        private const val NEGATIVE_NUMBER_THROW_MESSAGE = "can not use nagative number"
    }
}
