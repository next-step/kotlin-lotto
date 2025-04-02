package lotto

class WinningStatistics {
    private val rankCount = Rank.entries.associateWith { DEFAULT }.toMutableMap()

    fun addRank(rank: Rank) {
        rankCount[rank] = rankCount[rank]?.plus(1) ?: DEFAULT
    }

    companion object {
        private const val DEFAULT = 0
    }
}
