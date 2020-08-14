package stringAddCalculator

import stringAddCalculator.StringAddCalculator.Companion.ZERO

data class Number(val number: Int) {
    init {
        require(number >= ZERO) { "$NEGATIVE_NUMBER_THROW_MESSAGE $number" }
    }

    fun plus(targetNumber: Number) = Number(number + targetNumber.number)

    companion object {
        private const val NEGATIVE_NUMBER_THROW_MESSAGE = "can not use nagative number"
    }
}
