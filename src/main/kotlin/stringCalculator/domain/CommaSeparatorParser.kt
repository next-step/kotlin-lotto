package stringCalculator.domain

class CommaSeparatorParser(formula: String) : FormulaParser(formula) {
    override fun isUsingSeparator(): Boolean = COMMA_SEPARATOR in formula

    override fun parseFormula(): List<Int> {
        val formulaValues = formula.split(COMMA_SEPARATOR)
        return getNumberFormulaValues(formulaValues)
    }

    companion object {
        private const val COMMA_SEPARATOR = ","
    }
}
