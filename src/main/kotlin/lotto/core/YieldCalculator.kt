package lotto.core

import lotto.core.constant.LottoConstants

object YieldCalculator {
    fun calculate(
        winningRankCount: Map<WinningRank, Int>,
        lottoCount: Int,
    ): Float {
        val totalBudget = lottoCount * LottoConstants.LOTTO_PRICE
        val totalWinningAmount = winningRankCount.map { it.key.winningAmount * it.value }.sum()

        return totalWinningAmount.toFloat() / totalBudget
    }
}
