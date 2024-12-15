package lotto

import lotto.configuration.LottoConfiguration
import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutPutView

private val lottoController: LottoController =
    LottoConfiguration().LottoController()

fun main() {
    val amount = InputView.getLottoPurchaseAmount()
    val manualCount = InputView.getLottoManualCount()
    amount.setManualCount(manualCount)
    val lottoManualNumbers = InputView.getLottoManualNumbers(amount.getManualCount())
    val lottoInfo = lottoController.start(amount, lottoManualNumbers)
    OutPutView.printLottoInfo(lottoInfo)

    val winnerNumbers = InputView.getWinningNumber()
    val resultResponse = lottoController.getResult(winnerNumbers)
    OutPutView.printLottoResults(resultResponse, amount.amount)
}
