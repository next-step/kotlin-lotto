package lotto.domain

import lotto.dto.PurchasedLotteryPapers
import java.lang.Math.floor

class YieldCalculator {

    fun calulateYield(capital: Int, purchasedLotteryPapers: PurchasedLotteryPapers): Double {
        val lottoMatchResult = purchasedLotteryPapers.matchLottoResult
        var grossProfit = 0
        for ((prizeLevel, count) in lottoMatchResult) {
            grossProfit += prizeLevel.prizeMoney * count
        }
        val yeild = grossProfit / capital.toDouble()
        return roundToTwoDecimalPlaces(yeild)
    }

    private fun roundToTwoDecimalPlaces(number: Double): Double {
        return floor(number * 100) / 100
    }
}
