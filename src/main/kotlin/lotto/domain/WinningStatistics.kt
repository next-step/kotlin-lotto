package lotto.domain

class WinningStatistics(private val winningRanks: Ranks) {
    val winningCountByRank: Map<Rank, Int>
        get() = winningRanks.ranks.groupingBy { it }.eachCount()

    constructor(winningCountByRank: Map<Rank, Int>) : this(
        winningCountByRank.map { (rank, count) -> List(count) { rank } }
            .map { Ranks(it) }
            .reduce { acc, ranks -> acc + ranks },
    )

    private fun calculateTotalPrizeMoney(): Long {
        return winningRanks.calculateTotalPrizeMoney()
    }

    fun calculateProfitRate(purchaseMoney: PurchaseMoney): Double {
        val totalPrizeMoney = calculateTotalPrizeMoney()
        return totalPrizeMoney / purchaseMoney.value.toDouble()
    }
}
