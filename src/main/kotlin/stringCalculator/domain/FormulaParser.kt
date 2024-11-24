package stringCalculator.domain

import stringCalculator.domain.FormulaFormatException.NegativeNumberException
import stringCalculator.domain.FormulaFormatException.NotNumberFormatException
import stringCalculator.domain.FormulaFormatException.WrongFormatException

abstract class FormulaParser(internal val formula: String) {
    abstract fun isUsingSeparator(): Boolean
    abstract fun parseFormula(): List<Int>
    internal fun getNumberFormulaValues(stringValues: List<String>): List<Int> {
        val castedValue = stringValues.map { it.toIntOrNull() ?: throw NotNumberFormatException }
        castedValue.forEach { if (it <= 0) throw NegativeNumberException }
        return castedValue
    }

    companion object {
        fun toNumbers(vararg parsers: FormulaParser): List<Int> {
            parsers.toList().forEach { if (it.isUsingSeparator()) return it.parseFormula() }
            throw WrongFormatException
        }
    }
}
