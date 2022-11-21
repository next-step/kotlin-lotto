package calculator.domain

class Calculator {
    fun run(input: String?): Int {
        val separators = Separators()

        if (input.isNullOrBlank()) return ZERO
        val tokens = separators.separate(input)

        val positiveNumbers = PositiveNumbers.from(tokens)
        return positiveNumbers.sum()
    }

    companion object {
        private const val ZERO = 0
    }
}
