package lotto.domain

import java.math.BigDecimal

enum class Rank(val matchCount: Int, val prize: BigDecimal) {
    THREE(3, BigDecimal(5_000)),
    FOUR(4, BigDecimal(50_000)),
    FIVE(5, BigDecimal(1_500_000)),
    SIX(6, BigDecimal(2_000_000_000)),
    MISS(-1, BigDecimal(0)),
    ;

    fun totalPrize(count: Int): BigDecimal = prize.multiply(BigDecimal(count))

    companion object {
        fun from(matchCount: Int): Rank {
            return entries.find { it.matchCount == matchCount } ?: MISS
        }
    }
}
