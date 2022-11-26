package lotto.controller

import lotto.domain.LottoVendingMachine
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun run() {
        val purchaseAmount = InputView.getPurchaseAmount()
        ResultView.printNumberOfPurchases(purchaseAmount.getNumberOfLotto())

        val myLotto = LottoVendingMachine.buy(purchaseAmount)
        ResultView.printPurchasedLotto(myLotto)
    }
}
