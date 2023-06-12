package calculator.stringcalculator

import calculator.stringcalculator.splitter.StringSplitter

class StringSummingCalculator(private val splitters: List<StringSplitter>) : Calculator<String, PositiveNumber> {
    override fun calculate(input: String): PositiveNumber {
        if (input.isBlank()) {
            return PositiveNumber.ZERO
        }

        val positiveNumbers = splitInput(input).map { PositiveNumber.from(it) }

        return positiveNumbers.reduce { acc, number -> acc + number }
    }

    private fun splitInput(input: String): List<String> =
        splitters.find { it.supported(input) }?.split(input) ?: emptyList()
}
