package lotto

import lotto.controller.LottoController
import lotto.controller.PurchaseRequest
import lotto.view.InputView

class LottoRunner(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        val input = InputView.getPurchaseInput()
        controller.purchase(PurchaseRequest.from(input))
    }
}

fun main() {
    LottoRunner().run()
}
