package lotto.domain

import java.math.BigDecimal

class LottoPrizeStatics(winningLotto: WinningLotto, lottoList: List<Lotto>) {
    var profitRate = 0.0
        private set
    var prizeLottoMap: Map<Prize, Int> = Prize.values().associate { it to 0 }
        private set

    init {
        calculatePrizeLotto(lottoList, winningLotto)
        calculateProfitRate(lottoList.size)
    }

    private fun calculatePrizeLotto(lottoList: List<Lotto>, winningLotto: WinningLotto) {
        val prizeLotto = winningLotto.prizeLotto
        val prizeLottoMapResult = prizeLottoMap.toMutableMap()
        lottoList.filter { it.getCountOfMatchNumber(prizeLotto) >= Prize.FIFTH.countOfMatch }.forEach {
            val prize = winningLotto.getPrizeMoney(it)
            prizeLottoMapResult[prize] = prizeLottoMapResult[prize]!! + 1
        }
        prizeLottoMap = prizeLottoMapResult.toMap()
    }

    private fun calculateProfitRate(count: Int) {
        if (count == 0) return
        profitRate = prizeLottoMap.map { it.key.prizeMoney * it.value }
            .sumBy { it }.toBigDecimal()
            .divide((count * PRICE_OF_LOTTO).toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
            .stripTrailingZeros().toDouble()
    }
}
