package calculator

class PositiveNumbers(private val tokens: List<String>) {
    private val numbers: List<Int> = try {
        tokens.map { it.toInt() }
    } catch (e: NumberFormatException) {
        throw RuntimeException("Invalid token: $tokens")
    }

    init {
        require(numbers.all { it > 0 }) {
            "Negative numbers are not allowed"
        }
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    fun sum(): Int {
        return numbers.sum()
    }
}
