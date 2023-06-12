package calculator

import calculator.model.CalculatorErrorCode

class PositiveNumbers(elements: IntArray) {

    val elements: IntArray = elements.copyOf()
        get() = field.copyOf()

    init {
        val invalidNumbers = elements.filter { it < ZERO }

        require(value = invalidNumbers.isEmpty()) {
            CalculatorErrorCode.INVALID_POSITIVE_NUMBERS.message(invalidNumbers.joinToString())
        }
    }

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is PositiveNumbers -> false
        (elements contentEquals other.elements).not() -> false
        else -> true
    }

    override fun hashCode(): Int = elements.contentHashCode()

    companion object {
        private const val ZERO = 0
    }
}
