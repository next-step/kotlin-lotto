package lotto.domain

import lotto.util.NumberUtil

class LottoStatistics(
    private val winLottoList: List<WinLottoPrize>
) {
    private val prizeList: List<Int> = winLottoList.map { it.prizeMoney }
    private val totalPrize: Int = prizeList.sum()

    fun earningRate(inputPayment: Int): Double {
        val earningRate = totalPrize.toDouble() / inputPayment.toDouble()
        return NumberUtil.floor(earningRate, EARNING_RATE_DECIMAL_PLACE)
    }

    fun winLottoStatistics(): List<LottoStatisticsResult> {
        val hitCountMap = winLottoList.groupBy { winLottoPrize: WinLottoPrize -> winLottoPrize.hitCount }

        return WinLottoPrize.values().map {
            LottoStatisticsResult(
                winLottoPrize = it,
                winLottoCount = hitCountMap.getOrDefault(it.hitCount, emptyList()).size
            )
        }
    }

    companion object {
        private const val EARNING_RATE_DECIMAL_PLACE = 2
    }
}
