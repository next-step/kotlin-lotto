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

data class FormulaElement(
    val operand: Operand,
    val operator: Operation
) {
    constructor(operand: String, operator: Operation) : this(operand.toInt().toOperand(), operator)
}

class FormulaFormat(private val formula: String) {
    fun findCustomOperationDefinition(): String? {
        return CUSTOM_OPERATION_DEFINITION_REGEX.toRegex().matchEntire(formula)?.destructured?.toList()?.getOrNull(0)
    }

    fun normalFormula(): String = findCustomOperationDefinition()?.let {
        CUSTOM_OPERATION_DEFINITION_REGEX.toRegex().matchEntire(formula)?.destructured?.toList()?.getOrNull(1)
    } ?: formula


    companion object {
        private const val CUSTOM_OPERATION_DEFINITION_REGEX = "//(.)\n(.*)"
    }
}

interface Operand {
    val value: Int

    private abstract class Base(override val value: Int) : Operand {
        init {
            require(value >= 0)
        }

        override fun equals(other: Any?): Boolean {
            if (other !is Operand) return false
            return value == other.value
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }

    private class RealNumber(value: Int) : Base(value)

    companion object {
        fun Int.toOperand(): Operand = RealNumber(this)
    }
}

typealias Calculation = (leftOperand: Operand, rightOperand: Operand) -> Operand


enum class Operation(val symbol: String, val calculation: Calculation) {
    PLUS(
        "+",
        { leftOperand, rightOperand -> (leftOperand.value + rightOperand.value).toOperand() }
    );
}


data class CustomOperation(val symbol: String)
