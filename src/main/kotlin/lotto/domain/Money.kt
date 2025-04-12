package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Money(
    private val value: BigDecimal,
) : Comparable<Money> {
    init {
        require(value in MINIMUM_MONEY..MAXIMUM_MONEY) {
            "Amount value must be between 0 and 100,000"
        }
    }

    constructor(value: Int) : this(BigDecimal(value))

    fun getAffordableQuantity(value: BigDecimal): Int {
        val quantity =
            runCatching {
                this.value.divide(value, RoundingMode.DOWN)
            }.getOrNull() ?: BigDecimal.ZERO
        return quantity.toInt()
    }

    infix operator fun minus(value: BigDecimal): Money {
        check(this.value >= value) {
            "Not enough money to deduct $value."
        }
        return Money(this.value - value)
    }

    override fun compareTo(other: Money) = value.compareTo(other.value)

    companion object {
        private val MINIMUM_MONEY = BigDecimal(0)
        private val MAXIMUM_MONEY = BigDecimal(100_000)
    }
}
