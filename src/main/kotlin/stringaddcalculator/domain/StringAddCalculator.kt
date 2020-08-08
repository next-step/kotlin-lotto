package stringaddcalculator.domain

object StringAddCalculator {

    fun calculate(tokens: List<String>): Number {
        if (tokens.isEmpty()) return Number.ZERO
        return tokens.map { Number(it) }
            .reduce { acc, number -> acc.plus(number) }
    }
}
