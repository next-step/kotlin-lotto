package lottery.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money(
    val value: BigDecimal
) {
    init {
        require(value >= BigDecimal.ZERO) { "돈은 음수가 입력될 수 없다" }
    }

    fun times(count: Int) = Money(value.times(BigDecimal(count)))

    operator fun minus(money: Money) = Money(value.minus(money.value))

    operator fun div(money: Money) =
        value.divide(money.value, RoundingMode.DOWN) ?: throw IllegalArgumentException("나눌 수 없는 값이다")
}
