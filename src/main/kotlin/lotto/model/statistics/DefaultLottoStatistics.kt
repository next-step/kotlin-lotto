package lotto.model.statistics

import lotto.model.rank.LottoWinningRank

class DefaultLottoStatistics(
    override val winningRank: Map<Int, Int>,
    private val totalPurchaseAmount: Int,
) : LottoStatistics {
    override val profitRate: Double

    init {
        profitRate = calculateProfitRate()
    }

    private fun calculateProfitRate(): Double {
        val totalPrize = calculateTotalPrize()
        return if (totalPrize > 0) {
            totalPrize.toDouble().div(totalPurchaseAmount)
        } else {
            0.0
        }
    }

    private fun calculateTotalPrize(): Long {
        return winningRank.map { (key, count) ->
            (LottoWinningRank.DEFAULT_RANK_PRICE[key]?.toLong() ?: 0).times(count)
        }.sum()
    }
}
