package lotto.core

enum class WinningRank(val winningCount: Int, val winningAmount: Int) {
    RANK0(0, 0),
    RANK4(3, 5_000),
    RANK3(4, 50_000),
    RANK2(5, 1_500_000),
    RANK1(6, 2_000_000_000),
    ;

    companion object {
        private val map = entries.associateBy(WinningRank::winningCount)

        fun getWinningAmount(winningCount: Int): WinningRank {
            return map[winningCount] ?: RANK0
        }
    }
}
