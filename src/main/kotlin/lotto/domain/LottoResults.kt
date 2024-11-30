package lotto.domain

class LottoResults(ranks: List<LottoRank>) {
    val resultCountByRank: Map<LottoRank, Int> = ranks.groupingBy { it }.eachCount()

    fun calculateTotalPrizeAmount(): Long {
        return resultCountByRank.map { (rank, count) ->
            rank.prizeAmount * count
        }.sum()
    }
}
