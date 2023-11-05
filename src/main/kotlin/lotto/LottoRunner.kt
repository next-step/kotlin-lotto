package lotto

import lotto.controller.LottoController
import lotto.controller.PurchaseRequest
import lotto.view.InputView
import lotto.view.OutputView

class LottoRunner(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        val input = InputView.getPurchaseInput()
        val response = controller.purchase(PurchaseRequest.from(input))
        OutputView.drawPurchaseOutput(response)
    }
}

fun main() {
    LottoRunner().run()
}
