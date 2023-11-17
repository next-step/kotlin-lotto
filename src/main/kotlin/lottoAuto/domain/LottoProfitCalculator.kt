package lottoAuto.domain

import kotlin.math.floor

object LottoProfitCalculator {
    fun calcProfit(purchaseAmount: Int, totalWinningMoney: Int): LottoProfit {
        val rateOfReturn = calcRateOfReturn(purchaseAmount, totalWinningMoney)
        val resultMsg = when {
            rateOfReturn > 1.00 -> "이익"
            rateOfReturn == 1.00 -> "본전"
            else -> "손해"
        }
        return LottoProfit(rateOfReturn, resultMsg)
    }

    private fun calcRateOfReturn(purchaseAmount: Int, totalWinningMoney: Int): Double {
        if (purchaseAmount == 0) {
            return 0.00
        }
        val rateOfReturn = totalWinningMoney.toDouble() / purchaseAmount.toDouble()
        return floor(rateOfReturn * 100) / 100
    }
}
