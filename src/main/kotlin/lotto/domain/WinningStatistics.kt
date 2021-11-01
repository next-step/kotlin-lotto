package lotto.domain

class WinningStatistics(
    private val ranks: List<Rank>,
) {
    fun getCountByRank(rank: Rank): Int {
        return ranks.filter { it == rank }.size
    }

    fun getTotalReward(): Double {
        return ranks.sumOf { rank -> rank.reward }.toDouble()
    }
}
