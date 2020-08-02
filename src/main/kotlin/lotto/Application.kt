package lotto

import lotto.domain.Buyer
import lotto.view.InputView
import lotto.view.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val price = InputView.purchasePrice()

        Buyer(price).perchaseCount
        val purchaseCount = Buyer(price).purchaseCount
        ResultView.showPurchaseCount(purchaseCount)
    }
}
