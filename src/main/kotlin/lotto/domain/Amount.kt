package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

@JvmInline
value class Amount(
    private val value: BigDecimal,
) {
    init {
        require(value in MINIMUM_AMOUNT..MAXIMUM_AMOUNT) {
            "Amount value must be between 1,000 and 100,000 KRW"
        }
    }

    constructor(value: Int) : this(BigDecimal(value))

    fun divide(amount: Int): BigDecimal =
        runCatching {
            value.divide(amount.toBigDecimal(), RoundingMode.DOWN)
        }.getOrNull() ?: BigDecimal.ZERO

    companion object {
        private val MINIMUM_AMOUNT = BigDecimal(1_000)
        private val MAXIMUM_AMOUNT = BigDecimal(100_000)
    }
}
