package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(
    val value: BigDecimal
) {
    init {
        require(value >= BigDecimal.ZERO) {
            "돈은 0 보다 작을 수 없습니다."
        }
    }

    fun divideInt(other: Money): Int {
        return (this / other).value.toInt()
    }

    private operator fun div(other: Money): Money {
        return Money(value.divide(other.value, RoundingMode.DOWN))
    }

    operator fun compareTo(other: Money): Int {
        return this.value.compareTo(other.value)
    }

    operator fun minus(other: Money): Money {
        return Money(this.value - other.value)
    }
}
