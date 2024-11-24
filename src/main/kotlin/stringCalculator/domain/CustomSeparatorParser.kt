package stringCalculator.domain

import stringCalculator.domain.FormulaFormatException.CustomSeparatorFormatException

class CustomSeparatorParser(formula: String) : FormulaParser(formula) {
    override fun isUsingSeparator(): Boolean = formula.startsWith(CUSTOM_SEPARATOR_PREFIX)

    override fun parseFormula(): List<Int> {
        val regex = Regex("^$CUSTOM_SEPARATOR_PREFIX(.*?)$CUSTOM_SEPARATOR_POSTFIX")
        val customSeparator = regex.find(formula)?.groupValues?.get(1) ?: throw CustomSeparatorFormatException
        val pureFormula = formula.removePrefix(CUSTOM_SEPARATOR_PREFIX + customSeparator + CUSTOM_SEPARATOR_POSTFIX)
        val formulaValues = pureFormula.split(customSeparator)
        return getNumberFormulaValues(formulaValues)
    }

    companion object {
        private const val CUSTOM_SEPARATOR_PREFIX = "//"
        private const val CUSTOM_SEPARATOR_POSTFIX = "\n"
    }
}
