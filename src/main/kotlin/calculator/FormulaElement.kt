package calculator

import calculator.Operand.Companion.toOperand


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