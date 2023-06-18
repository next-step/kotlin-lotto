package calculator

import calculator.Operand.Companion.toOperand


class FormulaElements(
    private val formula: String,
    defaultOperations: List<CustomOperation> = DEFAULT_CUSTOM_OPERATIONS
) {
    private val customOperations: MutableList<CustomOperation>

    private val formulaFormat: FormulaFormat

    val startValue: Operand

    private val elements: MutableList<FormulaElement>

    init {
        customOperations = defaultOperations.toMutableList()
        formulaFormat = FormulaFormat(formula)
        formulaFormat.findCustomOperationDefinition()?.run { addPlusCustomOperation(this) }
        startValue = formulaStringNumbers().firstOrNull()?.toIntOrNull()?.toOperand() ?: 0.toOperand()
        elements = formulaStringNumbers()
            .drop(1)
            .map {
                FormulaElement(
                    it,
                    Operation.PLUS
                )
            }
            .let { ArrayDeque(it) }
    }

    fun nextFormulaElement(): FormulaElement? = elements.removeFirstOrNull()

    private fun addPlusCustomOperation(customOperation: String) {
        customOperations.add(CustomOperation(customOperation))
    }

    private fun formulaStringNumbers(): List<String> = customOperations.joinToString(separator = "|") { it.symbol }.toRegex().let { formulaFormat.normalFormula().split(it) }

    companion object {
        private val DEFAULT_CUSTOM_OPERATIONS = listOf(
            CustomOperation(","),
            CustomOperation(":")
        )
    }
}
