package stringcalculator.model

import java.math.BigDecimal
import java.math.BigDecimal.ZERO

class PositiveNumber(val value: BigDecimal) {

    init {
        require(value >= ZERO)
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
