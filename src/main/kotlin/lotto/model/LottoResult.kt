package lotto.model

import kotlin.math.floor

data class LottoResult(private val winningCountMap: Map<LottoPlace, Int>, val sumCostOfTickets: Money) {
    val benefitRate: Double
        get() {
            val totalWinnings = winningCountMap.entries.fold(Money.zero()) {
                accu, (lottoPlace, winningCount) -> accu.add(lottoPlace.winnings.times(winningCount))
            }

            val benefitRate = totalWinnings.dividedBy(sumCostOfTickets)
            return ceilToSecond(benefitRate)
        }

    private fun ceilToSecond(double: Double) = floor(double * 100) / 100
}
