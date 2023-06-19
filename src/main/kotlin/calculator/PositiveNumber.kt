package calculator

class PositiveNumber(numbers: List<Int>) {
    init {
        require(numbers.all { it > 0 }) {
            "Negative numbers are not allowed"
        }
    }
}
