package lotto.model

import java.math.BigDecimal
import java.math.RoundingMode

data class LottoResult(val winningCounter: WinningCounter, val sumCostOfTickets: Money) {
    val benefitRate: Double
        get() {
            val totalWinnings = winningCounter.winningsSum

            val benefitRate = totalWinnings.dividedBy(sumCostOfTickets)
            return ceilToSecond(benefitRate)
        }

    private fun ceilToSecond(double: Double) =
        BigDecimal(double).setScale(2, RoundingMode.DOWN).toDouble()
}
