package lotto.domain

import java.math.BigDecimal

enum class Rank(val matchCount: Int, val prize: BigDecimal) {
    FIRST(6, BigDecimal(2_000_000_000)),
    SECOND(5, BigDecimal(30_000_000)),
    THIRD(5, BigDecimal(1_500_000)),
    FOURTH(4, BigDecimal(50_000)),
    FIFTH(3, BigDecimal(5_000)),
    MISS(0, BigDecimal(0)),
    ;

    fun totalPrize(count: Int): BigDecimal = prize.multiply(BigDecimal(count))

    companion object {
        fun from(
            matchCount: Int,
            matchBonus: Boolean,
        ): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}
