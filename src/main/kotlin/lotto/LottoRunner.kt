package lotto

import lotto.controller.EndLottoRequest
import lotto.controller.LottoController
import lotto.controller.PurchaseRequest
import lotto.controller.PurchaseResponse
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
        return when(val response = controller.purchase(PurchaseRequest(amount, manualLottoNumbers))) {
            is PurchaseResponse.Success -> {
                OutputView.drawPurchaseOutput(response)
                true
            }
            is PurchaseResponse.Error -> {
                OutputView.drawError(response.message)
                false
            }
        }
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
