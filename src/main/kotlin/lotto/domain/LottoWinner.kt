package lotto.domain

class LottoWinner(
    private val luckyNumbers: LuckyNumbers
) {
    fun findWinLottoList(lottoList: List<Lotto>): List<LottoRank> {
        return lottoList
            .map { it.rank(luckyNumbers) }
            .filter { hasPrize(it) }
    }

    private fun hasPrize(lottoRank: LottoRank) = lottoRank.prizeMoney > 0
}
