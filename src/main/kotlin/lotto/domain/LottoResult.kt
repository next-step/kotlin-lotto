package lotto.domain

class LottoResult(
    val lottos: Lottos,
    val lottoMatchMap: LottoMatchMap,
    val profitRate: Double,
) {
    companion object {
        fun getLottoResult(
            lottos: Lottos,
            winningNumbers: WinningNumbers,
            bonusNumber: Int,
            purchasePrice: Int,
        ): LottoResult {
            val lottoMatchMap = getLottoMatchMap(lottos, winningNumbers, bonusNumber)
            val profit = getProfit(lottoMatchMap)
            val profitRate = getProfitRate(profit, purchasePrice)

            return LottoResult(lottos, lottoMatchMap, profitRate)
        }

        fun getLottoMatchMap(
            lottos: Lottos,
            winningNumbers: WinningNumbers,
            bonusNumber: Int,
        ): LottoMatchMap {
            val rankList =
                lottos.lottos.map { Rank.valueOf(winningNumbers.matchNumbers(it), it.numbers.contains(bonusNumber)) }
            return LottoMatchMap(Rank.entries.map { Pair(it, Rank.getRankCount(it, rankList)) }.toMap())
        }

        fun getProfit(lottoMatchMap: LottoMatchMap): Int {
            return lottoMatchMap.lottoMatchMap.map { it.key.winningMoney.times(it.value) }.sum()
        }

        fun getProfitRate(
            profit: Int,
            purchasePrice: Int,
        ): Double {
            return profit.toDouble().div(purchasePrice)
        }
    }
}
