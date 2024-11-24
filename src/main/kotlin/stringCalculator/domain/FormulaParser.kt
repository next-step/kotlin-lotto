package stringCalculator.domain

import stringCalculator.domain.FormulaFormatException.*

object FormulaParser {
    private const val COLON_SEPARATOR = ":"
    private const val COMMA_SEPARATOR = ","
    private const val CUSTOM_SEPARATOR_PREFIX = "//"
    private const val CUSTOM_SEPARATOR_POSTFIX = "\n"

    fun formulaToNumbers(formula: String): List<Int> {
        if (isUsingCustomSeparator(formula)) {
            return parseCustomSeparatorFormula(formula)
        }
        if (isUsingColonSeparator(formula)) {
            return parseColonSeparatorFormula(formula)
        }
        if (isUsingCommaSeparator(formula)) {
            return parseCommaSeparatorFormula(formula)
        }
        throw WrongFormatException
    }

    private fun isUsingCustomSeparator(formula: String): Boolean {
        val regex = Regex("^$CUSTOM_SEPARATOR_PREFIX.+$CUSTOM_SEPARATOR_POSTFIX.+")
        return regex.matches(formula)
    }

    private fun parseCustomSeparatorFormula(formula: String): List<Int> {
        val regex = Regex("^$CUSTOM_SEPARATOR_PREFIX(.*?)$CUSTOM_SEPARATOR_POSTFIX")
        val customSeparator = regex.find(formula)?.groupValues?.get(1) ?: throw CustomSeparatorFormatException
        val pureFormula = formula.removePrefix(CUSTOM_SEPARATOR_PREFIX + customSeparator + CUSTOM_SEPARATOR_POSTFIX)
        val formulaValues = pureFormula.split(customSeparator)
        return getNumberFormulaValues(formulaValues)
    }

    private fun isUsingColonSeparator(formula: String): Boolean = ":" in formula

    private fun parseColonSeparatorFormula(formula: String): List<Int> {
        val formulaValues = formula.split(COLON_SEPARATOR)
        return getNumberFormulaValues(formulaValues)
    }

    private fun isUsingCommaSeparator(formula: String): Boolean = ";" in formula

    private fun parseCommaSeparatorFormula(formula: String): List<Int> {
        val formulaValues = formula.split(COMMA_SEPARATOR)
        return getNumberFormulaValues(formulaValues)
    }

    private fun getNumberFormulaValues(stringValues: List<String>): List<Int> {
        val castedValue = stringValues.map { it.toIntOrNull() ?: throw NumberFormatException }
        castedValue.forEach { if (it <= 0) throw NegativeNumberException }
        return castedValue
    }
}
