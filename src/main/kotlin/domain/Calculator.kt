package domain

class Calculator {
    private var numbers = PositiveNumbers()
    private val separators = Separators()

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) return ZERO
        val tokens = separators.separate(input)
        numbers = PositiveNumbers.from(tokens)
        return numbers.sum()
    }

    companion object {
        private const val ZERO = 0
    }
}
