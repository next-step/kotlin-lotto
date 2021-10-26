package calculator

class PositiveNumbers(numbers: List<Int>) {

    init {
        numbers.forEach { number ->
            require(number >= 0)
        }
    }
}
