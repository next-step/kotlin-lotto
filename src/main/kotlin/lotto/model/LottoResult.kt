package lotto.model

import kotlin.math.floor

data class LottoResult(private val winningCounter: WinningCounter, val sumCostOfTickets: Money) {
    val benefitRate: Double
        get() {
            val totalWinnings = winningCounter.winningsSum

            val benefitRate = totalWinnings.dividedBy(sumCostOfTickets)
            return ceilToSecond(benefitRate)
        }

    private fun ceilToSecond(double: Double) = floor(double * 100) / 100
}
