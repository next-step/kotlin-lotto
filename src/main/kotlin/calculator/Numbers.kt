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
        val negatives = numbers.filter { it < 0 }
        if (negatives.isNotEmpty()) {
            throw NegativeNumberException(negatives)
        }
    }
}
