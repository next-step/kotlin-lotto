package lotto.domain

object LottoResultMachine {
    fun checkWinningLotto(winningLotto: Lotto, lotto: Lotto): LottoResult {
        val matchCount = winningLotto.numbers.intersect(lotto.numbers.toSet()).size
        return LottoResult(lotto, LottoPrize.of(matchCount))
    }

    fun calculateYield(lottoResultMap: Map<LottoPrize, List<LottoResult>>): Double {
        val totalPrizeMoney = lottoResultMap.map { (prize, lottoResults) ->
            prize.prizeMoney * lottoResults.size
        }.sum()
        return totalPrizeMoney.toDouble() / (Lotto.LOTTO_PRICE * lottoResultMap.values.flatten().size)
    }
}
