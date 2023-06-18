package calculator

import calculator.Operand.Companion.toOperand


class FormulaElements(
    private val formula: String,
    defaultOperations: List<CustomOperation> = DEFAULT_CUSTOM_OPERATIONS
) {
    val startValue: Operand

    private val elements: MutableList<FormulaElement>

    init {
        val customOperations = defaultOperations.toMutableList().also {
            FormulaFormat(formula).customOperationDefinition?.run { it.add(CustomOperation(this)) }
        }

        val formulaStringNumbers = customOperations.joinToString(separator = "|") { it.symbol }.toRegex()
            .let { FormulaFormat(formula).normalFormula.split(it) }

        startValue = formulaStringNumbers.firstOrNull()?.toIntOrNull()?.toOperand() ?: DEFAULT_START_VALUE
        elements = formulaStringNumbers
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

    companion object {
        private val DEFAULT_CUSTOM_OPERATIONS = listOf(
            CustomOperation(","),
            CustomOperation(":")
        )

        private val DEFAULT_START_VALUE = 0.toOperand()
    }
}
