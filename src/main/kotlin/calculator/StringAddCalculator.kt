package calculator

object StringAddCalculator {
    fun add(input: String?): Int {
        if (input.isNullOrBlank()) return 0

        return StringCalculatorProperties.of(input)
            .getPositiveInts()
            .sum()
    }
}
