package lotto.domain

class WinningStatistics(private val winningRanks: Ranks) {
    val winningCountByRank: Map<Rank, Int> = calculateWinningCountByRank()

    private fun calculateWinningCountByRank(): Map<Rank, Int> {
        return winningRanks.ranks.groupingBy { it }.eachCount()
    }

    private fun calculateTotalPrizeMoney(): Long {
        return winningRanks.calculateTotalPrizeMoney()
    }

    fun calculateProfitRate(purchaseMoney: PurchaseMoney): Double {
        val totalPrizeMoney = calculateTotalPrizeMoney()
        return totalPrizeMoney / purchaseMoney.value.toDouble()
    }
}
