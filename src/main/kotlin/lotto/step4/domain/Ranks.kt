package lotto.step4.domain

import lotto.step4.domain.LottoPurchaseManager.Companion.LOTTO_PRICE

class Ranks(private val rankMap: Map<Rank, Long>) {
    fun profit(): Double {
        val totalWinningAmount = Money(rankMap.entries.sumOf { (rank, count) -> rank.winningAmount.value * count })
        val totalPurchaseAmount = LOTTO_PRICE.multiply(rankMap.values.sum())
        return totalWinningAmount.value.toDouble() / totalPurchaseAmount.value
    }

    fun countOf(rank: Rank): Long {
        return rankMap[rank] ?: 0
    }

    fun asMap(): Map<Rank, Long> = rankMap
}
