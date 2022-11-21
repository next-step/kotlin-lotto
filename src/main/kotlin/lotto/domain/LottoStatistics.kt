package lotto.domain

import lotto.util.NumberUtil

object LottoStatistics {

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
        return NumberUtil.floor(earningRate, 2)
    }

    private fun calculatePrizeMoney(winLottoList: List<LottoResult>) = winLottoList.sumOf { it.prizeMoney }

    private fun winLottoStatistics(winLottoList: List<LottoResult>): List<LottoStatisticsResult> {
        val hitCountMap = winLottoList.groupBy { lottoResult: LottoResult -> lottoResult.hitCount }

        return Lotto.PRIZE_MONEY_PER_HIT_COUNT.map { entry ->
            val hitCount = entry.key
            val prizeMoney = entry.value
            LottoStatisticsResult(
                hitCount = hitCount,
                prizeMoney = prizeMoney,
                winLottoCount = hitCountMap.getOrDefault(hitCount, emptyList()).size
            )
        }
    }
}
