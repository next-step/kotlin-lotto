package lotto.domain

import lotto.util.NumberUtil

class LottoStatistics(
    private val winLottoList: List<LottoRank>
) {
    private val totalPrize: Int = winLottoList.sumOf { it.prizeMoney }

    fun earningRate(inputPayment: Payment): Double {
        val earningRate = totalPrize.toDouble() / inputPayment.payment.toDouble()
        return NumberUtil.floor(earningRate, EARNING_RATE_DECIMAL_PLACE)
    }

    fun winLottoStatistics(): List<LottoStatisticsResult> {
        val hitCountMap = winLottoList.groupBy { lottoRank: LottoRank -> lottoRank }

        return LottoRank.winRanks().map {
            LottoStatisticsResult(
                lottoRank = it,
                winLottoCount = hitCountMap.getOrDefault(it, emptyList()).size
            )
        }
    }

    companion object {
        private val EARNING_RATE_DECIMAL_PLACE = 2.0
    }
}
