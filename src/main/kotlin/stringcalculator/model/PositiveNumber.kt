package stringcalculator.model

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

class PositiveNumber(val value: BigDecimal) {

    init {
        require(value >= ZERO)
    }

    fun add(augend: PositiveNumber) = PositiveNumber(value.plus(augend.value))

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PositiveNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

    companion object {
        fun of(value: String): PositiveNumber {
            if (value.isBlank()) {
                return PositiveNumber(ZERO)
            }
            return PositiveNumber(BigDecimal(value))
        }
    }
}
