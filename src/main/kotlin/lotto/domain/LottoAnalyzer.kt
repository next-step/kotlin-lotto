package lotto.domain

class LottoAnalyzer(private val winLotto: Lotto, private val lottoPrice: Int = 1000) {

    fun createLottoStatics(lottos: List<Lotto>): LottoStatics {
        val ranks = lottos
            .map { lotto -> lotto.getCountOfMatch(winLotto) }
            .mapNotNull { matchCount ->
                if (matchCount < LottoRank.getMinCountOfMatchForWin()) null
                else LottoRank.valueOf(matchCount)
            }
            .groupingBy { rank -> rank }
            .eachCount()
            .toMutableMap()

        val totalBuyAmount = lottos.size * lottoPrice
        val totalWinningMoney = ranks.keys.sumOf { rank -> rank.winningMoney * ranks[rank]!! }
        val rateOfReturn = if (totalWinningMoney == 0) 0.0 else totalWinningMoney / totalBuyAmount.toDouble()

        return LottoStatics(ranks, totalBuyAmount, totalWinningMoney, rateOfReturn)
    }
}
