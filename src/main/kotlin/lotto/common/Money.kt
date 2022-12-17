package lotto.common

import java.math.BigDecimal

@JvmInline
value class Money(
    private val value: BigDecimal
) {

    companion object {
        fun from(value: Long): Money = Money(BigDecimal.valueOf(value))
    }
}