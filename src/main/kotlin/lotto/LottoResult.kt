package lotto

class LottoResult {
    private val result = mutableMapOf<Rank, Int>()

    init {
        Rank.values().forEach { result[it] = 0 }
    }

    fun putRank(rank: Rank) {
        result[rank] = result.getValue(rank) + 1
    }

    fun countByRank(rank: Rank): Int {
        return result.getValue(rank)
    }
}
