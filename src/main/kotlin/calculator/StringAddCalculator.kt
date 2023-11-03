package calculator

object StringAddCalculator {
    private val INITIAL_VALUE = PositiveOperand(0)

    fun add(input: String?): Int {
        if (input.isNullOrBlank()) {
            return PositiveOperand.ZERO.value
        }

        return Formula(input).getTokens()
            .map { PositiveOperand(it.toInt()) }
            .fold(INITIAL_VALUE) { acc, positiveOperand -> acc + positiveOperand }
            .value
    }
}
