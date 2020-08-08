package lotto

class LottoResult(private val result: Map<Rank, Int>) {
    fun countByRank(rank: Rank): Int {
        return result.getValue(rank)
    }
}
