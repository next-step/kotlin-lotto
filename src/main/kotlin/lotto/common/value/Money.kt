package lotto.common.value

import java.math.BigDecimal
import java.math.MathContext

@JvmInline
value class Money private constructor(
    val value: BigDecimal
) {

    init {
        require(value >= BigDecimal.ZERO) { "돈의 값은 0이랑 같거나 커야 합니다." }
    }

    operator fun times(quantity: Quantity): Money {
        return Money(this.value.times(BigDecimal.valueOf(quantity.value.toLong())))
    }

    operator fun div(target: Money): Money {
        return Money(this.value.divide(target.value, MathContext.DECIMAL32))
    }

    override fun toString(): String = this.value.toString()

    operator fun minus(target: Money): Money {
        return Money(this.value.minus(target.value))
    }

    companion object {
        fun Long.toMoney(): Money = Money(this.toBigDecimal())
        fun BigDecimal.toMoney(): Money = Money(this)
    }
}
