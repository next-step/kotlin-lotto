package lotto

import java.text.DecimalFormat

class LottoGameStatistics(purchaseAmount: Int, val result: Map<Rank, Int>) {
    private val totalReward = result.map { it.key.reward * it.value }.sum()
    val roi = DecimalFormat("#.##").format(totalReward.toDouble() / purchaseAmount)
}