package lotto.core

import lotto.core.constant.LottoConstants

object YieldCalculator {
    fun calculate(lottos: Lottos): Float {
        val totalWinningAmount = lottos.sumOf { it.winningRank.winningAmount }
        val totalBudget = lottos.size * LottoConstants.LOTTO_PRICE

        return totalWinningAmount.toFloat() / totalBudget
    }
}
