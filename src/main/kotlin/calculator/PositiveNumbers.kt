package calculator

import calculator.model.CalculatorErrorCode

@JvmInline
value class PositiveNumbers(val elements: List<Int>) : List<Int> by elements {

    init {
        val invalidNumbers = elements.filter { it < ZERO }

        require(value = invalidNumbers.isEmpty()) {
            CalculatorErrorCode.INVALID_POSITIVE_NUMBERS.message(invalidNumbers.joinToString())
        }
    }

    companion object {
        private const val ZERO = 0
    }
}
