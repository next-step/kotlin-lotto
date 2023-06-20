package lotto.domain

class LottoResult(
    private val result: Map<LottoRank, Int>
) {

    constructor(ranks: List<LottoRank>) : this(ranks.groupingBy { it }.eachCount())

    fun getRankCount(rank: LottoRank): Int {
        return result[rank] ?: 0
    }
}
