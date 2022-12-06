package lotto.domain

import lotto.domain.vo.PurchaseAmount

enum class WinningPrize(val matchedCount: Int, val prize: Int) {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 30_000_000),
    THIRD_PRIZE(5, 1_500_000),
    FOURTH_PRIZE(4, 50_000),
    FIFTH_PRIZE(3, 5_000),
    NONE(0, 0);

    fun calculateRateOfReturn(purchaseAmount: PurchaseAmount): Double {
        return prize.toDouble() / purchaseAmount.amount
    }

    companion object {
        fun find(matchedCount: Int, hasBonusNumber: Boolean = false): WinningPrize {
            val winningPrize = values().firstOrNull { it.matchedCount == matchedCount } ?: return NONE

            return winningPrize.takeIf { it == SECOND_PRIZE && !hasBonusNumber }?.let { THIRD_PRIZE } ?: winningPrize
        }
    }
}
