package lotto

object LottoStatistic {
    fun getLottoWinningCountOfLottoRank(lottos: List<Lotto>, winningNumbers: List<Int>, lottoRank: LottoRank): Int {
        return lottos.filter { lotto ->
            lotto.getContainLottoNumberSameCount(winningNumbers) == lottoRank.sameCount
        }.size
    }
}
