package calculator

class StringAddCalculator {
    fun add(stringFormula: String?): Int {
        val formulaElements = FormulaElements(stringFormula ?: "")
        var result = formulaElements.startValue
        while (true) {
            formulaElements.nextFormulaElement()?.run { result = operator.calculator(result, operand) } ?: break
        }
        return result.value
    }
}
