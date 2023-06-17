package lotto

import java.math.BigDecimal

enum class Prize(
    val matchedCount: Int,
    val prizeAmount: BigDecimal,
) {
    FIRST(6, BigDecimal(2_000_000_000)),
    SECOND(5, BigDecimal(30_000_000)),
    THIRD(5, BigDecimal(1_500_000)),
    FOURTH(4, BigDecimal(50_000)),
    FIFTH(3, BigDecimal(5_000)),
    MISS(0, BigDecimal.ZERO),
    ;

    fun isNotMiss(): Boolean = this != MISS

    fun isBonusMatched(): Boolean = this == SECOND

    companion object {
        fun match(matchedCount: Int, bonusMatched: Boolean): Prize {
            if (matchedCount == 5) {
                return if (bonusMatched) SECOND else THIRD
            }

            return values().find { it.matchedCount == matchedCount } ?: MISS
        }
    }
}
