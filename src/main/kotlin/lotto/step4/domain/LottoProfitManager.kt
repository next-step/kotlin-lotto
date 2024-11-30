package lotto.step4.domain

import lotto.step4.domain.LottoPurchaseManager.Companion.LOTTO_PRICE

object LottoProfitManager {
    fun computeProfit(rankMap: Map<Rank, Long>): Double {
        val totalWinningAmount =
            rankMap.entries.sumOf { (rank, count) ->
                rank.winningAmount.value * count
            }
        val totalPurchaseAmount = LOTTO_PRICE.multiply(rankMap.values.sum())
        return totalWinningAmount.toDouble() / totalPurchaseAmount.value
    }
}
