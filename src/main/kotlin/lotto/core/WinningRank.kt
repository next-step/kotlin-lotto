package lotto.core

enum class WinningRank(val winningCount: Pair<Int, Boolean>, val winningAmount: Int) {
    NOTHING(0 to false, 0),
    FIFTH(3 to false, 5_000),
    FORTH(4 to false, 50_000),
    THIRD(5 to false, 1_500_000),
    FIRST(6 to false, 2_000_000_000),
    SECOND(5 to true, 30_000_000),
    ;

    companion object {
        private val RANK_BY_WINNING_COUNT = entries.associateBy(WinningRank::winningCount)

        fun getRank(
            winningCount: Int,
            matchBonus: Boolean,
        ): WinningRank {
            return RANK_BY_WINNING_COUNT[winningCount to matchBonus] ?: NOTHING
        }
    }

    fun totalWinningAmount(count: Int): Int = winningAmount * count
}
