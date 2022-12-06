package lotto.domain

import lotto.domain.vo.PurchaseAmount

class WinningPrizes(private val winningPrizes: List<WinningPrize>) {
    fun extractStatisticOfMatchedCount(): Map<Int, Int> {
        return winningPrizes.map { it.matchedCount to it.prize }
            .groupingBy { it.first }
            .eachCount()
    }

    fun calculateTotalRateOfReturn(purchaseAmount: PurchaseAmount): Double {
        return winningPrizes.sumOf { it.calculateRateOfReturn(purchaseAmount) }
    }
}
