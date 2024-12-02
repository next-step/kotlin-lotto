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
            var ranks = entries.filter { it.winningCount == winningCount }
            if (ranks.isEmpty()) {
                return NOTHING
            }

            if (ranks.size == 1) {
                return ranks[0]
            }

            ranks = ranks.filter { it.matchBonus == matchBonus }
            return if (ranks.size > 0) ranks[0] else NOTHING
        }
    }

    fun totalWinningAmount(count: Int): Int = winningAmount * count
}
