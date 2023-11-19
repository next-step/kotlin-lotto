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
        if(!purchaseLotto()) return
        createWinningNumbers()
    }

    private fun purchaseLotto(): Boolean {
        val amount = InputView.getPurchaseAmount() ?: return false
        val manualLottoNumbers = InputView.getManualLottoNumbers() ?: return false
        val response = controller.purchase(PurchaseRequest.from(amount))
        OutputView.drawPurchaseOutput(response)
        return true
    }

    private fun createWinningNumbers(): Boolean {
        val winningNumbers = InputView.getWinningNumbersInput() ?: return false
        val bonusNumber = InputView.getBonusNumberInput() ?: return false
        val response = controller.end(EndLottoRequest(winningNumbers, bonusNumber))
        OutputView.drawEarningRateOutput(response)
        return true
    }
}

fun main() {
    LottoRunner().run()
}
