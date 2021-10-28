package calculator

data class PositiveNumbers(private val numbers: List<Int>) {

    init {
        numbers.forEach { number ->
            require(number >= 0)
        }
    }

    fun sum(): Int = numbers.sum()

    companion object {
        fun from(strings: List<String>): PositiveNumbers = strings
            .map { it.toInt() }
            .let(::PositiveNumbers)
    }
}
