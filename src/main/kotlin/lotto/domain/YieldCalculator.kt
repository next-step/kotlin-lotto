package lotto.domain

import lotto.dto.LottoMatchResult

class YieldCalculator {

    fun calculateYield(capital: Int, lottoMatchResult: LottoMatchResult): Double {
        val matchLottoResult = lottoMatchResult.getMatchLottoResult()
        var grossProfit = 0
        for ((prizeLevel, count) in matchLottoResult) {
            grossProfit += prizeLevel.prizeMoney * count
        }
        val yield = grossProfit / capital.toDouble()
        return roundToTwoDecimalPlaces(yield)
    }

    private fun roundToTwoDecimalPlaces(number: Double): Double {
        return kotlin.math.floor(number * 100) / 100
    }
}
