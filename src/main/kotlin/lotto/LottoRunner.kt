package lotto

import lotto.controller.EndLottoRequest
import lotto.controller.EndLottoResponse
import lotto.controller.LottoController
import lotto.controller.PurchaseRequest
import lotto.controller.PurchaseResponse
import lotto.view.InputView
import lotto.view.OutputView

class LottoRunner(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        if (!purchaseLotto()) return
        createWinningNumbers()
    }

    private fun purchaseLotto(): Boolean {
        val request = kotlin.runCatching {
            InputView.purchaseRequest
        }.getOrElse {
            OutputView.drawError(it.message)
            return false
        }

        return when (val response = controller.purchase(request)) {
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
        val request = runCatching {
            InputView.endLottoRequest
        }.getOrElse {
            OutputView.drawError(it.message)
            return false
        }
        return when (val response = controller.end(request)) {
            is EndLottoResponse.Success -> {
                OutputView.drawEarningRateOutput(response)
                true
            }

            is EndLottoResponse.Error -> {
                OutputView.drawError(response.message)
                false
            }
        }
    }
}

fun main() {
    LottoRunner().run()
}
