package lotto.common.value

import java.math.BigDecimal
import java.math.MathContext

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

    operator fun div(target: Money): Money {
        return Money(this.value.divide(target.value, MathContext.DECIMAL32))
    }

    override fun toString(): String = "${this.value}원"

    companion object {
        fun from(value: Long): Money = Money(BigDecimal.valueOf(value))
        fun BigDecimal.toMoney(): Money = Money(this)
    }
}
