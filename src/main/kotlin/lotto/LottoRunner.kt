package lotto

import lotto.presentation.controller.LottoController
import lotto.presentation.controller.dto.EvaluateRequest
import lotto.presentation.controller.dto.PurchaseRequest
import lotto.presentation.view.InputView
import lotto.presentation.view.OutputView

class LottoRunner private constructor(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        val purchaseRequest = PurchaseRequest.from(InputView.getPurchaseInput())
        val purchaseResponse = controller.purchase(purchaseRequest)

        OutputView.drawLottoTicketsOutput(purchaseResponse)

        val inputWinNumbers = InputView.getWinningNumbersInput()
        val inputBonusNumber = InputView.getBonusNumberInput()

        val evaluateRequest = EvaluateRequest.from(inputWinNumbers, inputBonusNumber)
        val evaluateResponse = controller.evaluate(purchaseResponse, evaluateRequest)

        OutputView.drawLottoResultOutput(evaluateResponse)
    }

    companion object {
        fun run() = run { LottoRunner().run() }
    }
}

fun main() {
    LottoRunner.run()
}
