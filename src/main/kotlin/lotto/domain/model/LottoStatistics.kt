package lotto.domain.model

import lotto.domain.Rank

class LottoStatistics(
    val totalPurchaseAmount: Int,
    val winningStatistics: WinningStatistics,
) {

    fun getCountByRank(rank: Rank): Int {
        return winningStatistics.getCountByRank(rank)
    }

    fun getYield(): Double {
        return winningStatistics.getTotalReward() / totalPurchaseAmount
    }
}
