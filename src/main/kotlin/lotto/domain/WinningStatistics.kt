package lotto.domain

data class WinningStatistics(
    private val statistics: Map<Rank, Int> = INITIAL_STATISTICS
) {
    fun add(matches: List<Int>): WinningStatistics {
        val ranks = matches.mapNotNull { Rank.valueOf(it) }
        val newWinningStatistics = statistics.toMutableMap()
        ranks.forEach {
            newWinningStatistics[it] = newWinningStatistics[it]!! + 1
        }

        return this.copy(statistics = newWinningStatistics)
    }

    fun getNumberOfMatchCount(rank: Rank): Int {
        return statistics.filterKeys { it == rank }.values.first()
    }

    companion object {
        private const val INITIAL_COUNT = 0
        private val INITIAL_STATISTICS = Rank.values().associateWith { INITIAL_COUNT }
    }
}
