package lotto

import lotto.controller.LottoController
import lotto.view.OutputView

class LottoRunner(
    private val controller: LottoController = LottoController()
) {
    fun run() {
        runCatching {
            OutputView.drawPurchaseTicket(controller.purchase())
            OutputView.drawLottoResult(controller.end())
        }.getOrElse {
            OutputView.drawError(it.message)
        }
    }
}

fun main() {
    LottoRunner().run()
}
