package stringCalculator.domain

import stringCalculator.domain.FormulaFormatException.CustomSeparatorFormatException

class CustomSeparatorParser(formula: String) : FormulaParser(formula) {
    override fun isUsingSeparator(): Boolean = formula.startsWith(CUSTOM_SEPARATOR_PREFIX)

    override fun parseFormula(): List<Int> {
        val customSeparator = getCustomSeparator(formula)
        val pureFormula = formula.removePrefix(CUSTOM_SEPARATOR_PREFIX + customSeparator + CUSTOM_SEPARATOR_POSTFIX)
        val formulaValues = pureFormula.split(customSeparator)
        return getNumberFormulaValues(formulaValues)
    }

    private fun getCustomSeparator(formula: String): String {
        val prefixIndex = formula.indexOf(CUSTOM_SEPARATOR_PREFIX) + CUSTOM_SEPARATOR_PREFIX.length
        val postfixIndex = formula.indexOf(CUSTOM_SEPARATOR_POSTFIX)

        if (prefixIndex < CUSTOM_SEPARATOR_PREFIX.length || postfixIndex == -1) {
            throw CustomSeparatorFormatException
        }

        return formula.substring(prefixIndex, postfixIndex)
    }

    companion object {
        private const val CUSTOM_SEPARATOR_PREFIX = "//"
        private const val CUSTOM_SEPARATOR_POSTFIX = "\\n"
    }
}
