package lotto

data class LottoResult(val result: Map<Rank, Int>) {
    fun totalReward(): Long {
        return result.map { it.key.reward * it.value }.sum()
    }

    fun countByRank(rank: Rank): Int {
        return result[rank] ?: 0
    }
}
