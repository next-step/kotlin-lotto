package lotto

import kotlin.math.floor

class WinnerLottoData(private val winnerLottoDataList: List<LottoData>, private val lottoPrizeInfo: LottoPrizeInfo, private val paymentAmount: Int) {

    var winnerGroup: Map<Int, List<LottoData>> = winnerLottoDataList.filter { !it.hasMatchBonusNumber }.groupBy { it.getMatchedNumberCount() }
    var winnerGroupWithBonus: Map<Int, List<LottoData>> = winnerLottoDataList.filter { it.hasMatchBonusNumber }.groupBy { it.getMatchedNumberCount() }

    fun getWinnerStepCount(stepNumber: Int): Int {
        return winnerGroup[stepNumber]?.size ?: 0
    }

    fun getWinnerStepCountWithBonusNumber(stepNumber: Int): Int {
        return winnerGroupWithBonus[stepNumber - 1]?.size ?: 0
    }

    fun getLottoPrizeDataList(): List<LottoPrizeData> {
        return lottoPrizeInfo.lottoPrizeDataList
    }

    fun getPrizeRate(): Double {
        var totalSum = 0
        getLottoPrizeDataList().forEach {
            totalSum += it.prizeMoney * getWinnerCountOrItWithBonusCount(it)
        }
        val result = if (totalSum <= 0) 0.0 else totalSum.toDouble().div(paymentAmount.toDouble())
        return floor(result * 100) / 100
    }

    private fun getWinnerCountOrItWithBonusCount(lottoPrizeData: LottoPrizeData): Int {
        return if (lottoPrizeData.includeBonusNumber) getWinnerStepCountWithBonusNumber(lottoPrizeData.matchCount) else getWinnerStepCount(lottoPrizeData.matchCount)
    }
}
