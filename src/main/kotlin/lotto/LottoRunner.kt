package lotto

import lotto.controller.EndLottoRequest
import lotto.controller.LottoController
import lotto.controller.PurchaseRequest
import lotto.view.InputView
import lotto.view.OutputView

class LottoRunner(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        purchaseLotto()
        createWinningNumbers()
    }

    private fun purchaseLotto() {
        val input = InputView.getPurchaseInput()
        val response = controller.purchase(PurchaseRequest.from(input))
        OutputView.drawPurchaseOutput(response)
    }

    private fun createWinningNumbers() {
        val input = InputView.getWinningNumbersInput()
        controller.end(EndLottoRequest.from(input))
    }
}

fun main() {
    LottoRunner().run()
}
