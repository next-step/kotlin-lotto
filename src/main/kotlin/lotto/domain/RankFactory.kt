package lotto.domain

class RankFactory {
    private val rankFactory: MutableMap<Rank, Int> = mutableMapOf()

    init {
        for (rank in Rank.values()) {
            rankFactory[rank] = 0
        }
    }

    fun addRank(rank: Rank) {
        val currentCount = rankFactory[rank] ?: 0
        rankFactory[rank] = currentCount + 1
    }

    fun getRankCount(rank: Rank): Int {
        return rankFactory[rank] ?: 0
    }

    fun calculateTotalPrize(): Double {
        return rankFactory.entries.sumOf { it.key.winningMoney * it.value }.toDouble()
    }

    fun getRanks(): List<Rank> {
        return rankFactory.entries.map { entry -> entry.key }.toList()
    }
}
