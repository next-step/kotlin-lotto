package calculator.model

object AddCalculator {
    private const val DEFAULT_SUM = 0

    fun calculate(input: String?): Int {
        if (input.isNullOrBlank()) {
            return DEFAULT_SUM
        }

        val numbers = Separator.separate(input)
        return PositiveNumbers.from(numbers).sum
    }
}
