package stringcalculator.workflow

import stringcalculator.entity.Formula

class StringAddCalculator {
    fun add(formula: Formula): Int {
        val numbers = formula.expression.split(formula.delimiter)
        return numbers.map { it.toInt() }.reduce { acc, number -> acc + number }
    }
}