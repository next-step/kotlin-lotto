package lotto.model

import java.math.BigDecimal

enum class LottoPrize(
    val matchCount: Int,
    val prize: BigDecimal
) {
    FIRST(6, BigDecimal.valueOf(2_000_000_000)),
    SECOND(5, BigDecimal.valueOf(1_500_000)),
    THIRD(4, BigDecimal.valueOf(50_000)),
    FOURTH(3, BigDecimal.valueOf(5_000)),
    NONE(0, BigDecimal.ZERO);

    companion object {
        fun of(matchCount: Int): LottoPrize {
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}
