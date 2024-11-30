package lotto.domain

class LottoResults(ranks: List<LottoRank>) {
    private val winningLottoCountByRank = ranks.groupingBy { it }.eachCount()

    fun calculateTotalPrizeAmount(): Long {
        return winningLottoCountByRank.map { (rank, count) ->
            rank.prizeAmount * count
        }.sum()
    }

    fun getWinningLottoCountBy(lottoRank: LottoRank): Int {
        return winningLottoCountByRank[lottoRank] ?: 0
    }
}
