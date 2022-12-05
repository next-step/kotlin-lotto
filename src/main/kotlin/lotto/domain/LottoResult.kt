package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(private val purchasePrice: Money, val lottoWinningAmount: LottoWinningAmount) {
    fun calculateReturnRate(): Double {
        val totalWinningAmount = lottoWinningAmount.sum()

        return rateAsScaledDouble(totalWinningAmount)
    }

    private fun rateAsScaledDouble(totalWinningAmount: Money, scale: Int = DEFAULT_RATE_SCALE): Double {
        return BigDecimal(totalWinningAmount.div(purchasePrice)).setScale(scale, RoundingMode.HALF_EVEN).toDouble()
    }

    companion object {
        const val DEFAULT_RATE_SCALE = 2
    }
}
