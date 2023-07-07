package lotto

import java.text.DecimalFormat

class LottoGameStatistics(purchaseAmount: Int, val result: LottoResult) {
    private val totalReward = result.totalReward()
    val roi: String = DecimalFormat("#.##").format(totalReward.toDouble() / purchaseAmount)

    fun countByRank(rank: Rank): Int {
        return result.countByRank(rank)
    }
}
