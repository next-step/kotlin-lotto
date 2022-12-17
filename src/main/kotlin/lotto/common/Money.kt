package lotto.common

import java.math.BigDecimal

@JvmInline
value class Money(
    val value: BigDecimal
) {

    init {
        require(value >= BigDecimal.ZERO) { "돈의 값은 0이랑 같거나 커야 합니다." }
    }

    operator fun times(quantity: Quantity): Money {
        return Money(this.value.times(BigDecimal.valueOf(quantity.value)))
    }

    companion object {
        fun from(value: Long): Money = Money(BigDecimal.valueOf(value))
    }
}