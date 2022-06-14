package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

data class Money(
    val value: BigDecimal
) {
    init {
        require(value > BigDecimal.ZERO) {
            "돈은 0 보다 작을 수 없습니다."
        }
    }

    fun divideInt(other: Money): Int {
        return value.divide(other.value, RoundingMode.DOWN)
            .toInt()
    }
}
