package lotto.step4.domain

import lotto.step4.domain.LottoPurchaseManager.Companion.LOTTO_PRICE

object AutoLottoPurchasableMoneyCalculator {
    fun calculateMoney(
        money: Money,
        manualPurchaseCount: Long,
    ): Money {
        return money.minus(LOTTO_PRICE.multiply(manualPurchaseCount))
    }
}
