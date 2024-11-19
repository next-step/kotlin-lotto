package lotto

import lotto.view.InputView
import lotto.view.ResultView


fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    ResultView.printPurchaseAmount(purchaseAmount)

}

