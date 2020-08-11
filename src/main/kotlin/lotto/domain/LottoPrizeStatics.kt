package lotto.domain

import java.math.BigDecimal

class LottoPrizeStatics {

    var profitRate = 0.0
        private set

    fun checkMatches(prizeLotto: Lotto, lottos: List<Lotto>) {
        val prized = lottos.filter { it.checkPrize(prizeLotto).prizeMoney > 0 }
        val totalPrizeMoney = prized.sumBy { Prize.getPrizeMoney(it.countOfMatch) }
        prized.forEach { Prize.getPrize(it.countOfMatch).addCount() }
        calculateProfitRate(lottos.size, totalPrizeMoney)
    }

    private fun calculateProfitRate(count: Int, totalPrizeMoney: Int) {
        profitRate = totalPrizeMoney.toBigDecimal()
            .divide((count * PRICE_OF_LOTTO).toBigDecimal(), 2, BigDecimal.ROUND_HALF_EVEN)
            .stripTrailingZeros().toDouble()
    }
}
