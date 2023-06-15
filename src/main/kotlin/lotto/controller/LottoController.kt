package lotto.controller

import lotto.domain.LottoPurchase
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()
    private val lottoPurchase = LottoPurchase()

    fun run() {
        val budget = inputView.inputPurchasePrice()
        val purchaseAmount = LottoPurchase.affordableLottoCount(budget)

        val lottos = lottoPurchase.purchaseAuto(purchaseAmount)
        resultView.printPurchaseAmount(purchaseAmount)
        resultView.printLottos(lottos)

    }
}
