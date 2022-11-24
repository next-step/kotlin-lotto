package stringcalculator.model

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

data class PositiveNumber(val value: BigDecimal) {

    init {
        require(value >= ZERO) { "value 값은 음수가 될 수 없습니다" }
    }

    fun add(augend: PositiveNumber) = PositiveNumber(value.plus(augend.value))

    companion object {
        fun of(value: String): PositiveNumber {
            if (value.isBlank()) {
                return PositiveNumber(ZERO)
            }
            return PositiveNumber(BigDecimal(value))
        }
    }
}
