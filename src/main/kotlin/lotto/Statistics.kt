package lotto

import java.math.BigDecimal

class Statistics(winningLotto: WinningLotto, lottos: List<Lotto>) {

    private val lottoRanks = LottoRanks()
    private val totalMoney = lottos.size * LottoSeller.LOTTO_PRICE

    init {
        lottos.map { lottoRanks.add(LottoRank.selectRank(winningLotto.matchCount(it.lotto))) }
    }

    fun getWinningResult(): Map<LottoRank, Int> {
        return lottoRanks.getRanks().filterNot { it.key == LottoRank.LOSE }
    }

    fun getYield(): Double {
        return lottoRanks.getWinPrice()
            .divide(BigDecimal(totalMoney))
            .toDouble()
    }
}
