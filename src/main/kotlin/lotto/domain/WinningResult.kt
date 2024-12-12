package lotto.domain

class WinningResult(private val winningStatistics: Map<Rank, Int>) {
    fun calculateTotalPrize(): Int {
        return winningStatistics.entries.sumOf { (rank, count) ->
            rank.matchCount * count
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        return calculateTotalPrize().toDouble() / purchaseAmount
    }

    fun getWinningCount(matchCount: Int): Int {
        return winningStatistics[Rank.from(matchCount)] ?: 0
    }
}
