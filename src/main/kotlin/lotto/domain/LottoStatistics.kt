package lotto.domain

import lotto.common.IntegerNumber
import lotto.util.NumberUtil

class LottoStatistics(
    private val winLottoList: List<LottoRank>
) {
    private val totalPrize: IntegerNumber = IntegerNumber(winLottoList.sumOf { it.prizeMoney.number })

    fun earningRate(inputPayment: Payment): Double {
        val earningRate = totalPrize.toDouble() / inputPayment.payment.toDouble()
        return NumberUtil.floor(earningRate, EARNING_RATE_DECIMAL_PLACE)
    }

    fun winLottoStatistics(): List<LottoStatisticsResult> {
        val hitCountMap = winLottoList.groupBy { lottoRank: LottoRank -> lottoRank }

        return LottoRank.winRanks().map {
            LottoStatisticsResult(
                lottoRank = it,
                winLottoCount = IntegerNumber(hitCountMap.getOrDefault(it, emptyList()).size)
            )
        }
    }

    companion object {
        private const val EARNING_RATE_DECIMAL_PLACE = 2
    }
}
