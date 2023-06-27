package lotto

import lotto.vo.Money

interface LottoShop {
    fun sell(cash: Money, purchaseCommand: PurchaseCommand): Pair<Lottos, Money>
}
