package stringaddcalculator

object StringAddCalculator {
    fun add(formula: String?): Int {
        if(formula.isNullOrEmpty()) return 0

        val delimiters = DelimiterFinder.find(formula)

        return Parse(formula, delimiters).result.reduce { acc, current -> acc + current }
    }
}