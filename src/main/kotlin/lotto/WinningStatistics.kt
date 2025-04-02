package lotto

class WinningStatistics(private val rankCount: Map<Rank, Int>) {
    fun calculateProfit(cost: Double): Double {
        return rankCount.entries.sumOf { (rank, count) -> rank.prize * count } / cost
    }

    fun countBy(rank: Rank): Int {
        return rankCount[rank] ?: DEFAULT
    }

    companion object {
        private const val DEFAULT = 0
    }
}
