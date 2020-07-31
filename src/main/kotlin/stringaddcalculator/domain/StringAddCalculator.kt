package stringaddcalculator.domain

object StringAddCalculator {

    fun calculate(tokens: List<String>): Int {
        return tokens.map(String::toInt)
            .sum()
    }
}
