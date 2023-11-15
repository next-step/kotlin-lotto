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
        val winningNumbers = InputView.getWinningNumbersInput()
        val bonusNumber = InputView.getBonusNumberInput()
        val response = controller.end(EndLottoRequest.from(winningNumbers, bonusNumber))
        OutputView.drawEarningRateOutput(response)
    }
}

fun main() {
    LottoRunner().run()
}
