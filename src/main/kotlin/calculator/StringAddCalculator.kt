package calculator

object StringAddCalculator {
    private val INITIAL_VALUE = PositiveOperand("0")

    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return INITIAL_VALUE.toInt()
        }

        return Formula(input).getTokens()
            .map { PositiveOperand(it) }
            .fold(INITIAL_VALUE, PositiveOperand::plus)
            .toInt()
    }
}
