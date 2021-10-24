package calculator.domain

import calculator.exception.InvalidExpressionException

@JvmInline
value class Number(
    private val value: String,
) {

    init {
        if (!numberRegex.containsMatchIn(value) || value.toInt() < MINIMUM_NUMBER) {
            throw InvalidExpressionException()
        }
    }

    fun toInt(): Int = value.toInt()

    companion object {
        private val numberRegex: Regex = Regex("[0-9]")
        private const val MINIMUM_NUMBER = 0
    }
}
