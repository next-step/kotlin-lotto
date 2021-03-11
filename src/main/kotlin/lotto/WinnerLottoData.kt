package lotto

import kotlin.math.floor

class WinnerLottoData(val winnerLottoDataList: List<LottoData>, val lottoPrizeInfo: LottoPrizeInfo, val paymentAmount: Int) {

    var winnerGroup: Map<Int, List<LottoData>> = winnerLottoDataList.groupBy { it.getMatchedNumberCount() }

    fun getWinnerStepCount(stepNumber: Int): Int {
        return winnerGroup[stepNumber]?.size ?: 0
    }

    fun getLottoPrizeDataList(): List<LottoPrizeData> {
        return lottoPrizeInfo.lottoPrizeDataList
    }

    fun getPrizeRate(): Double {
        var totalSum = 0
        getLottoPrizeDataList().forEach {
            totalSum += (it.prizeMoney * getWinnerStepCount(it.matchCount))
        }
        val result = if (totalSum <= 0) 0.0 else totalSum.toDouble().div(paymentAmount.toDouble())
        return floor(result * 100) / 100
    }
}
