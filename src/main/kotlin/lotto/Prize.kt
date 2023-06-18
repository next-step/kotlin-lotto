package lotto

import java.math.BigDecimal

enum class Prize(
    val matchedCount: Int,
    val prizeAmount: BigDecimal,
    val bonusMatched: Boolean,
) {
    FIRST(6, BigDecimal(2_000_000_000), false),
    SECOND(5, BigDecimal(30_000_000), true),
    THIRD(5, BigDecimal(1_500_000), false),
    FOURTH(4, BigDecimal(50_000), false),
    FIFTH(3, BigDecimal(5_000), false),
    MISS(0, BigDecimal.ZERO, false),
    ;

    fun isNotMiss(): Boolean = this != MISS

    fun isBonusMatched(): Boolean = this == SECOND

    companion object {
        private val MATCHED_COUNT_5_PRIZE = listOf(SECOND, THIRD)

        fun match(matchedCount: Int, bonusMatched: Boolean): Prize {
            if (matchedCount == 5) {
                return MATCHED_COUNT_5_PRIZE.find { it.bonusMatched == bonusMatched } ?: MISS
            }

            return values().find { it.matchedCount == matchedCount } ?: MISS
        }
    }
}
