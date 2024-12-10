package lotto.domain

class WinningResult(private val winningStatistics: Map<Int, Int>) {
    fun calculateTotalPrize(): Int {
        return winningStatistics.entries.sumOf { (matchCount, count) ->
            Rank.from(matchCount).prize * count
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        return calculateTotalPrize().toDouble() / purchaseAmount
    }

    fun getWinningCount(matchCount: Int): Int {
        return winningStatistics[matchCount] ?: 0
    }
}
