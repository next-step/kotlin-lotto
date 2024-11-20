package calulator

class Numbers(private val numbers: List<Int>) {
    init {
        validateNonNegative(numbers)
    }

    private fun validateNonNegative(numbers: List<Int>) {
        if (numbers.any { it < 0 }) {
            throw RuntimeException()
        }
    }

    fun sum(): Int = numbers.sum()
}
