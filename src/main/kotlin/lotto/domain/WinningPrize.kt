package lotto.domain

import lotto.domain.vo.PurchaseAmount

enum class WinningPrize(val matchedCount: Int, val prize: Int) {
    FIRST_PRIZE(6, 2_000_000_000),
    SECOND_PRIZE(5, 1_500_000),
    THIRD_PRIZE(4, 50_000),
    FOURTH_PRIZE(3, 5_000),
    NONE(0, 0);

    fun calculateRateOfReturn(purchaseAmount: PurchaseAmount): Double {
        return prize.toDouble() / purchaseAmount.amount
    }

    companion object {
        fun find(matchedCount: Int): WinningPrize {
            return values().firstOrNull { it.matchedCount == matchedCount } ?: return NONE
        }
    }
}
