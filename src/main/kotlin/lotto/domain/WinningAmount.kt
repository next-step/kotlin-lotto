package lotto.domain

import java.math.BigDecimal

enum class WinningAmount(
    val matchCount: Int,
    val amount: BigDecimal,
) {
    FIRST(6, BigDecimal.valueOf(2_000_000_000)),
    SECOND(5, BigDecimal.valueOf(30_000_000)),
    THIRD(5, BigDecimal.valueOf(1_500_000)),
    FOURTH(4, BigDecimal.valueOf(50_000)),
    FIFTH(3, BigDecimal.valueOf(5_000)),
    MISS(0, BigDecimal.valueOf(0)),
    ;

    companion object {
        fun findByMatchCount(matchCount: Int, matchBonus: Boolean): WinningAmount = when (matchCount) {
            FIRST.matchCount -> FIRST
            SECOND.matchCount -> if (matchBonus) SECOND else THIRD
            FOURTH.matchCount -> FOURTH
            FIFTH.matchCount -> FIFTH
            else -> MISS
        }
    }
}
