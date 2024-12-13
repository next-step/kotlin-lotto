package lotto.domain

class WinningResult(private val winningStatistics: Map<Rank, Int>) {
    companion object {
        private const val NO_WINNING_COUNT = 0
    }

    fun calculateTotalPrize(): Int {
        return winningStatistics.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        return calculateTotalPrize().toDouble() / purchaseAmount
    }

    fun getWinningCount(rank: Rank): Int {
        return winningStatistics[rank] ?: NO_WINNING_COUNT
    }
}
