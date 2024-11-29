package lotto

import lotto.domain.LottoPurchaseController
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoApplication = LottoApplication()
    lottoApplication.run()
}

class LottoApplication {
    fun run() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        val lottos = LottoPurchaseController.purchaseLotto(purchaseAmount)
        ResultView.printLotto(lottos)
    }
}
