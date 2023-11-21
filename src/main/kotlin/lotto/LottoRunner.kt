package lotto

import lotto.presentation.controller.dto.EvaluateRequest
import lotto.presentation.controller.LottoController
import lotto.presentation.controller.dto.PurchaseRequest
import lotto.presentation.view.InputView
import lotto.presentation.view.OutputView

class LottoRunner private constructor(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        purchaseLotto()
        evaluateByWinningNumbers()
    }

    private fun purchaseLotto() {
        val req = PurchaseRequest.from(InputView.getPurchaseInput())

        val resp = controller.purchase(req)

        OutputView.drawLottoTicketsOutput(resp)
    }

    private fun evaluateByWinningNumbers() {
        val inputWinNumbers = InputView.getWinningNumbersInput()
        val inputBonusNumber = InputView.getBonusNumberInput()

        val req = EvaluateRequest.from(inputWinNumbers, inputBonusNumber)

        val resp = controller.evaluate(req)

        OutputView.drawLottoResultOutput(resp)
    }

    companion object {
        fun run() = run { LottoRunner().run() }
    }
}

fun main() {
    LottoRunner.run()
}
