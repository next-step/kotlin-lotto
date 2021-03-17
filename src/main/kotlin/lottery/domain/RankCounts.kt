package lottery.domain

class RankCounts {
    val rankCounts: HashMap<Rank, Int> = hashMapOf()

    fun addMatchCount(count: Rank) {
        rankCounts[count] = rankCounts.getOrDefault(count, DEFAULT_MATCH_COUNT) + ADD_COUNT_VALUE
    }

    fun retrieve(rank: Rank): Int {
        return rankCounts.getOrDefault(rank, DEFAULT_MATCH_COUNT)
    }

    fun calculateJackpots(): Int {
        return rankCounts.map { it.key.price * it.value }.sum()
    }

    companion object {
        const val DEFAULT_MATCH_COUNT = 0
        const val ADD_COUNT_VALUE = 1
    }
}
