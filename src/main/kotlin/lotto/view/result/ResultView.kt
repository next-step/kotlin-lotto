package lotto.view.result

import lotto.domain.LottoPurchaseCount

interface ResultView {
    fun showPurchaseCount(purchaseCount: LottoPurchaseCount)
}
