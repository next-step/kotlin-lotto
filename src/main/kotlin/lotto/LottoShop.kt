package lotto

import lotto.vo.Money

interface LottoShop {
    fun sell(cash: Money, manualPurchaseCommand: ManualPurchaseCommand): Lottos
}
