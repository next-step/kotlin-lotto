package lottoAuto.domain

import kotlin.math.floor

object LottoStatsEngine {
    private const val LOTTO_PRICE = 1000

    fun calcNumOfLotto(purchaseAmount: Int): Int {
        return purchaseAmount / LOTTO_PRICE
    }

    fun calcRateOfReturn(purchaseAmount: Int, totalWinningMoney: Int): Double {
        if (purchaseAmount == 0) {
            return 0.00
        }
        val rateOfReturn = totalWinningMoney.toDouble() / purchaseAmount.toDouble()
        return floor(rateOfReturn * 100) / 100
    }
}
