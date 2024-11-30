package lotto.core

import lotto.core.constant.LottoConstants

class LottoResult(val winningRankCount: Map<WinningRank, Int>) {
    fun calculateYield(lottoCount: Int): Float {
        val totalBudget = lottoCount * LottoConstants.LOTTO_PRICE
        val totalWinningAmount = winningRankCount.map { it.key.totalWinningAmount(it.value) }.sum()

        return totalWinningAmount.toFloat() / totalBudget
    }
}
