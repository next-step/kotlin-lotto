package calculator

class PositiveNumbers(private val numbers: List<Int>) {
    init {
        require(numbers.all { it > 0 }) {
            "Negative numbers are not allowed"
        }
    }

    fun sum(): Int {
        return numbers.sum()
    }
}
