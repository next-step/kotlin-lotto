package lotto.domain

import java.math.BigDecimal

enum class Rank(val prizeMoney: BigDecimal, val matchingNumberCount: Int) {
    FIRST(BigDecimal.valueOf(2_000_000_000), 6),
    SECOND(BigDecimal.valueOf(30_000_000), 5),
    THIRD(BigDecimal.valueOf(1_500_000), 5),
    FOURTH(BigDecimal.valueOf(50_000), 4),
    FIFTH(BigDecimal.valueOf(5_000), 3),
    ;

    companion object {
        fun fromMatchCount(
            matchCount: Int,
            isMatchBonus: Boolean,
        ): Rank? {
            return if (isMatchBonus && matchCount == 5) {
                SECOND
            } else if (matchCount == 5) {
                THIRD
            } else {
                entries.find { matchCount == it.matchingNumberCount }
            }
        }

        fun getRanksFromLowest(): List<Rank> =
            listOf(
                FIFTH,
                FOURTH,
                THIRD,
                SECOND,
                FIRST,
            )
    }
}
