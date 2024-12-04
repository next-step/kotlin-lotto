package lotto.core

enum class WinningRank(val winningCount: Int, val matchBonus: Boolean, val winningAmount: Int) {
    NOTHING(0, false, 0),
    FIFTH(3, false, 5_000),
    FORTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    ;

    companion object {
        private val RANK_BY_WINNING_COUNT = entries.associateBy(WinningRank::winningCount)

        fun getRank(
            winningCount: Int,
            matchBonus: Boolean,
        ): WinningRank {
            val ranks = entries.filter { it.winningCount == winningCount }

            return when (ranks.size) {
                0 -> NOTHING
                1 -> ranks.first()
                else -> ranks.firstOrNull { it.matchBonus == matchBonus } ?: NOTHING
            }
        }
    }

    fun totalWinningAmount(count: Int): Int = winningAmount * count
}
