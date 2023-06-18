package stringcalculator.workflow

import stringcalculator.entity.Formula

class StringAddCalculator {
    fun add(formula: Formula): Int {
        return formula.extractNumbers().sumOf { it.toInt() }
    }
}
