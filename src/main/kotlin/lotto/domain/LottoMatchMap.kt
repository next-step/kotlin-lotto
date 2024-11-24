package lotto.domain

class LottoMatchMap(val lottoMatchMap: Map<Rank, Int>) {
    fun drawMatchMap() {
        lottoMatchMap.forEach { println("${it.key}등 : ${it.value}개") }
    }

    fun getProfitRate(): Double {
        return getProfit().toDouble().div(getLottoPurchaseCount().times(Lotto.PRICE))
    }

    private fun getLottoPurchaseCount(): Int {
        return lottoMatchMap.map { it.value }.sum()
    }

    private fun getProfit(): Int {
        return lottoMatchMap.map { it.key.winningMoney.times(it.value) }.sum()
    }

    companion object {
        fun getLottoMatchMap(
            lottos: Lottos,
            winningNumbers: WinningNumbers,
            bonusNumber: Int,
        ): LottoMatchMap {
            val rankList =
                lottos.lottos.map { Rank.valueOf(winningNumbers.matchNumbers(it), it.numbers.contains(bonusNumber)) }
            return LottoMatchMap(Rank.entries.map { Pair(it, Rank.getRankCount(it, rankList)) }.toMap())
        }
    }
}
