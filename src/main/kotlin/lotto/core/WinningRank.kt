package lotto.core

enum class WinningRank(val winningCount: Int, val winningAmount: Int) {
    NOTHING(0, 0),
    FORTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        private val RANK_BY_WINNING_COUNT = entries.associateBy(WinningRank::winningCount)

        fun getRank(winningCount: Int): WinningRank {
            return RANK_BY_WINNING_COUNT[winningCount] ?: NOTHING
        }
    }
}
