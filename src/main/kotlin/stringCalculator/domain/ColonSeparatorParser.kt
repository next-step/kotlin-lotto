package stringCalculator.domain

class ColonSeparatorParser(formula: String) : FormulaParser(formula) {
    override fun isUsingSeparator(): Boolean = COLON_SEPARATOR in formula

    override fun parseFormula(): List<Int> {
        val formulaValues = formula.split(COLON_SEPARATOR)
        return getNumberFormulaValues(formulaValues)
    }

    companion object {
        private const val COLON_SEPARATOR = ":"
    }
}
