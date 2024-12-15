package lotto.domain

class LottoResults(ranks: List<LottoRank>) {
    private val winningLottoCountByRank = ranks.groupingBy { it }.eachCount()

    fun calculateTotalPrizeAmount(): LottoAmount {
        return winningLottoCountByRank.map { (rank, count) ->
            rank.prizeAmount * count
        }.sum()
    }

    private fun Iterable<LottoAmount>.sum(): LottoAmount {
        return fold(LottoAmount(0)) { accumulate, amount -> accumulate + amount }
    }

    fun getWinningLottoCountBy(lottoRank: LottoRank): Int {
        return winningLottoCountByRank[lottoRank] ?: 0
    }
}
