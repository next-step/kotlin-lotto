package lotto.step4.domain

object LottoProfitManager {
    fun computeProfit(rankMap: Map<Rank, Int>): Double {
        val totalWinningAmount =
            rankMap.entries.sumOf { (rank, count) ->
                rank.winningAmount * count
            }
        val totalPurchaseAmount = rankMap.values.sum() * 1000
        return totalWinningAmount.toDouble() / totalPurchaseAmount
    }
}
