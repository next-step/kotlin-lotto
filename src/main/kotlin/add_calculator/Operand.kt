package add_calculator

import java.lang.RuntimeException

class Operand(text: String) {
    val value: PositiveNumber

    init {
        val number = text.toIntOrNull() ?: throw RuntimeException()
        value = PositiveNumber(number)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Operand

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
