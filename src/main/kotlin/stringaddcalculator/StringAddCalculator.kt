package stringaddcalculator

object StringAddCalculator {
    fun add(formula: String): Int {
        if (formula.isEmpty()) return 0

        // val delimiters = DelimiterFinder.find(formula)
        // return Parse(formula, delimiters).result.reduce { acc, current -> acc + current }

        val expression = Expression(formula)

        return expression.parse().reduce { acc, current -> acc + current }
    }
}