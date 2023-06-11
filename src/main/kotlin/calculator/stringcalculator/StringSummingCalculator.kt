package calculator.stringcalculator

import calculator.stringcalculator.splitter.Splitter

class StringSummingCalculator(val splitters: List<Splitter<String, List<String>>>) : Calculator<String, Number> {
    override fun calculate(input: String): Number {
        if (input.isBlank()) {
            return Number.ZERO
        }

        val numbers = splitInput(input).map { Number.from(it) }

        return numbers.reduce { acc, number -> acc + number }
    }

    private fun splitInput(input: String): List<String> =
        splitters.find { it.supported(input) }?.split(input) ?: emptyList()
}
