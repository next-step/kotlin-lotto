package calculator

object PositiveNumber {
    fun checkPositiveNumbers(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException("Negative numbers are not allowed")
        }
    }
}
