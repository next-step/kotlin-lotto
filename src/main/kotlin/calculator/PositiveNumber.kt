package calculator

class PositiveNumber(numbers: List<Int>) {
    init {
        require(numbers.all { it > 0 }) {
            throw RuntimeException("Negative numbers are not allowed")
        }
    }
}
