package lottery.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money(
    val value: BigDecimal,
) {
    init {
        require(value >= BigDecimal.ZERO) { "돈은 음수가 입력될 수 없다" }
    }

    fun times(count: Int): Money = Money(value.times(BigDecimal(count)))

    fun divide(money: Money): BigDecimal = value.divide(money.value, RoundingMode.DOWN)

    fun isDivisible(money: Money): Boolean = value.rem(money.value) == BigDecimal.ZERO

    operator fun plus(money: Money) = Money(value.plus(money.value))

    operator fun minus(money: Money) = Money(value.minus(money.value))
}
