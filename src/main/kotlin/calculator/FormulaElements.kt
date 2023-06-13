package calculator

import calculator.Operand.Companion.toOperand


class FormulaElements(
    private val formula: String,
    defaultOperations: List<CustomOperation> = DEFAULT_CUSTOM_OPERATIONS
) {

    private val customOperations: MutableList<CustomOperation>

    val startValue: Operand

    private val elements: MutableList<FormulaElement>


    init {
        customOperations = defaultOperations.toMutableList()
        findCustomOperationDefinition()?.run { addPlusCustomOperation(this) }
        startValue = splittedByOperandAndOperator().firstOrNull()?.toIntOrNull()?.toOperand() ?: 0.toOperand()
        elements = splittedByOperandAndOperator()
            .drop(1)
            .chunked(2)
            .fold<List<String>, MutableList<FormulaElement>>(mutableListOf()) { bucket, operandWithOperator ->
                bucket.apply {
                    add(
                        FormulaElement(
                            operandWithOperator[1],
                            customOperations.first { operandWithOperator[0] == it.symbol }.implementation
                        )
                    )
                }
            }
            .let { ArrayDeque(it) }
    }

    fun nextFormulaElement(): FormulaElement? = elements.removeFirstOrNull()

    private fun addPlusCustomOperation(customOperation: String) {
        customOperations.add(CustomOperation(customOperation, Operation.PLUS))
    }

    private fun findCustomOperationDefinition(): String? {
        return CUSTOM_OPERATION_DEFINITION_REGEX.toRegex().matchEntire(formula)?.destructured?.toList()?.getOrNull(0)
    }

    private fun normalFormula(): String = findCustomOperationDefinition()?.let {
        CUSTOM_OPERATION_DEFINITION_REGEX.toRegex().matchEntire(formula)?.destructured?.toList()?.getOrNull(1)
    } ?: formula

    private fun operatorOperandSplitRegex(): Regex = Regex("(\\d+|\\D+)")

    private fun splittedByOperandAndOperator(): List<String> = operatorOperandSplitRegex().findAll(normalFormula()).map { it.value }.toList()

    companion object {
        private val DEFAULT_CUSTOM_OPERATIONS = listOf(
            CustomOperation(",", Operation.PLUS),
            CustomOperation(":", Operation.PLUS)
        )

        private const val CUSTOM_OPERATION_DEFINITION_REGEX = "//(.)\n(.*)"
    }
}

data class FormulaElement(
    val operand: Operand,
    val operator: Operation
) {
    constructor(operand: String, operator: Operation) : this(operand.toInt().toOperand(), operator)
}

interface Operand {
    val value: Int

    private abstract class Base : Operand {
        override fun equals(other: Any?): Boolean {
            if (other !is Operand) return false
            return value == other.value
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }

    private class RealNumber(override val value: Int) : Base()

    companion object {
        operator fun invoke(value: Int): Operand = RealNumber(value)

        fun Int.toOperand(): Operand = RealNumber(this)
    }
}

typealias Calculation = (leftOperand: Operand, rightOperand: Operand) -> Operand


enum class Operation(val symbol: String, val calculation: Calculation) {
    PLUS(
        "+",
        { leftOperand, rightOperand -> (leftOperand.value + rightOperand.value).toOperand() }
    );

    companion object {
        fun of(operation: String): Operation? = values().find { it.symbol == operation }
    }
}


data class CustomOperation(val symbol: String, val implementation: Operation)
