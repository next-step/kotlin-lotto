package lotto

import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutputView

class LottoRunner(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        runCatching {
            purchaseLotto()
            createWinningNumbers()
        }.getOrElse {
            OutputView.drawError(it.message)
        }
    }

    private fun purchaseLotto() {
        val request = InputView.purchaseRequest
        val response = controller.purchase(request)
        OutputView.drawPurchaseOutput(response)
    }

    private fun createWinningNumbers() {
        val request = InputView.endLottoRequest
        val response = controller.end(request)
        OutputView.drawEarningRateOutput(response)
    }
}

fun main() {
    LottoRunner().run()
}
