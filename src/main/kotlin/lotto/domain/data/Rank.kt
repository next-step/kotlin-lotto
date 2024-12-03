package lotto.domain.data

import java.math.BigDecimal

enum class Rank(val prizeMoney: BigDecimal, val matchingNumberCount: Int) {
    FIRST(BigDecimal(2_000_000_000), 6),
    THIRD(BigDecimal(1_500_000), 5),
    SECOND(BigDecimal(30_000_000), 5),
    FOURTH(BigDecimal(50_000), 4),
    FIFTH(BigDecimal(5_000), 3),
    ;

    companion object {
        fun fromCount(count: Int): Rank {
            return entries.find { count == it.matchingNumberCount }
                ?: throw IllegalArgumentException("invalid count $count")
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
