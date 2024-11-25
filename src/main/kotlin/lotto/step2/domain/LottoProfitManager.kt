package lotto.step2.domain

import lotto.step2.domain.Lotto.Companion.PRICE

object LottoProfitManager {
    fun computeProfit(lottos: List<Lotto>): Double {
        val totalWinningAmount =
            lottos.sumOf { lotto ->
                when (lotto.matchCount) {
                    3 -> RewardType.THIRD.winningAmount
                    4 -> RewardType.FOURTH.winningAmount
                    5 -> RewardType.SECOND.winningAmount
                    6 -> RewardType.FIRST.winningAmount
                    else -> 0
                }
            }
        val totalPurchaseAmount = lottos.size * PRICE
        return totalWinningAmount.toDouble() / totalPurchaseAmount
    }
}
