package add_calculator

import java.lang.RuntimeException

class Operand(text: String) {
    val positiveNumber: PositiveNumber

    init {
        val number = text.toIntOrNull() ?: throw RuntimeException()
        positiveNumber = PositiveNumber(number)
    }

    fun add(acc: Int): Int {
        return positiveNumber.value + acc
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operand

        if (positiveNumber != other.positiveNumber) return false

        return true
    }

    override fun hashCode(): Int {
        return positiveNumber.hashCode()
    }
}
