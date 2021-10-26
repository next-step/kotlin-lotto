package calculator

class PositiveNumbers(private val numbers: List<Int>) {

    init {
        numbers.forEach { number ->
            require(number >= 0)
        }
    }

    fun sum(): Int = numbers.sum()
}
