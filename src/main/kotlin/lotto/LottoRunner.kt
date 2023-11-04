package lotto

import lotto.controller.LottoController
import lotto.controller.PurchaseRequest
import lotto.view.InputView

object LottoRunner {
    fun run() {
        val input = InputView.getPurchaseInput()
        LottoController.purchase(PurchaseRequest.from(input))
    }
}

fun main() {
    LottoRunner.run()
}
