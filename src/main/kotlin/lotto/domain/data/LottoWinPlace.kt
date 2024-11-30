package lotto.domain.data

import java.math.BigDecimal

enum class LottoWinPlace(val prizeMoney: BigDecimal, val matchingNumberCount: Int) {
    FOURTH(BigDecimal(5000), 3),
    THIRD(BigDecimal(50000), 4),
    SECOND(BigDecimal(1_500_000), 5),
    FIRST(BigDecimal(2_000_000_000), 6),
    ;

    companion object {
        fun fromCount(count: Int): LottoWinPlace {
            return entries.find { count == it.matchingNumberCount }
                ?: throw IllegalArgumentException("invalid count $count")
        }

        fun getPlacesFromLowest(): List<LottoWinPlace> =
            listOf(
                FOURTH,
                THIRD,
                SECOND,
                FIRST,
            )
    }
}
