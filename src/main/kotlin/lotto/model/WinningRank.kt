package lotto.model

enum class WinningRank(
    val matchedNumberCount: Int,
    val prizeMoney: Int,
    private val isBonusNumberNecessary: Boolean
) {

    FIRST_PRIZE(6, 2_000_000_000, false),
    SECOND_PRIZE(5, 30_000_000, true),
    THIRD_PRIZE(5, 1_500_000, false),
    FOURTH_PRIZE(4, 50_000, false),
    FIFTH_PRIZE(3, 5_000, false),
    NONE(0, 0, false);

    companion object {
        fun of(matchedNumberCount: Int, matchBonusNumber: Boolean): WinningRank {
            val ranks = values().filter { it.matchedNumberCount == matchedNumberCount }

            if (ranks.size == 1) {
                return ranks[0]
            }

            return ranks.firstOrNull { it.isBonusNumberNecessary == matchBonusNumber } ?: NONE
        }
    }
}
