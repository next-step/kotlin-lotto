package lotto

class WinningStatistics {
    private val rankCount = Rank.entries.associateWith { DEFAULT }.toMutableMap()

    fun addRank(rank: Rank) {
        rankCount[rank] = rankCount[rank]?.plus(1) ?: DEFAULT
    }

    fun calculateProfit(cost: Double): Double {
        return rankCount.entries.sumOf { (rank, count) -> rank.prize * count } / cost
    }

    fun countBy(rank: Rank): Int {
        return rankCount[rank] ?: 0
    }

    companion object {
        private const val DEFAULT = 0
    }
}
