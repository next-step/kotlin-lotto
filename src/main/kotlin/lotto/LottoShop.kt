package lotto

import lotto.vo.Money

object LottoShop {
    val LOTTO_PRICE = Money(1000)
    fun sell(cash: Money, lottoPurchaseCommand: LottoPurchaseCommand): Lottos {
        val amountOfLotto = cash / LOTTO_PRICE

        return Lottos(lottoPurchaseCommand.fetchPurchaseLottoByCount(amountOfLotto.toInt()))
    }
}
