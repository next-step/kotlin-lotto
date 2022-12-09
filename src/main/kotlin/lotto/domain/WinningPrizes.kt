package lotto.domain

import lotto.domain.vo.PurchaseAmount

class WinningPrizes(private val winningPrizes: List<WinningPrize>) {
    fun extractStatisticOfWinningPrize(): Map<WinningPrize, Int> {
        return winningPrizes.groupingBy { it }.eachCount()
    }

    fun calculateTotalRateOfReturn(purchaseAmount: PurchaseAmount): Double {
        return winningPrizes.sumOf { it.calculateRateOfReturn(purchaseAmount) }
    }
}
