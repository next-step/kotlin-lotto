package lotto.domain

import lotto.util.NumberUtil

object LottoStatistics {

    private const val EARNING_RATE_DECIMAL_PLACE = 2

    fun statistics(inputPayment: Int, lottoResults: List<LottoResult>): LottoStatisticsTotal {
        val winLottoList = lottoResults.filter { hasPrizeMoney(it) }
        val earningRate = earningRate(inputPayment, winLottoList)
        val winLottoStatisticsResult = winLottoStatistics(winLottoList)
        return LottoStatisticsTotal(
            earningRate = earningRate,
            winLottoStatisticsResult = winLottoStatisticsResult
        )
    }

    private fun hasPrizeMoney(it: LottoResult) = it.prizeMoney > 0

    private fun earningRate(inputPayment: Int, winLottoList: List<LottoResult>): Double {
        val totalPrizeMoney = calculatePrizeMoney(winLottoList)
        val earningRate = totalPrizeMoney.toDouble() / inputPayment.toDouble()
        return NumberUtil.floor(earningRate, EARNING_RATE_DECIMAL_PLACE)
    }

    private fun calculatePrizeMoney(winLottoList: List<LottoResult>) = winLottoList.sumOf { it.prizeMoney }

    private fun winLottoStatistics(winLottoList: List<LottoResult>): List<LottoStatisticsResult> {
        val hitCountMap = winLottoList.groupBy { lottoResult: LottoResult -> lottoResult.hitCount }

        return WinLottoPrize.values().map {
            LottoStatisticsResult(
                winLottoPrize = it,
                winLottoCount = hitCountMap.getOrDefault(it.hitCount, emptyList()).size
            )
        }
    }
}
