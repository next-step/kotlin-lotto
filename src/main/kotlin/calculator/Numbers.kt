package calculator

import calculator.exception.NegativeNumberException

class Numbers(private val numbers: List<Int>) {
    init {
        validate()
    }

    fun sum(): Int {
        return numbers.sum()
    }

    private fun validate() {
        numbers.find { it > 0 } ?: throw throw NegativeNumberException()
    }
}
